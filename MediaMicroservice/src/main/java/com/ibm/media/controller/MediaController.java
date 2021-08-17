package com.ibm.media.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.media.dao.CommentsDao;
import com.ibm.media.dao.MediaDao;
import com.ibm.media.dao.NewsFeedDao;
import com.ibm.media.model.Comments;
import com.ibm.media.model.Media;
import com.ibm.media.model.NewsFeed;
import com.ibm.media.service.MediaService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/media")
public class MediaController {
	
	@Autowired
	private MediaDao mediadao;
	
	@Autowired
	private NewsFeedDao newsFeedDao;
	
	@Autowired
	private MediaService mediaservice;
	
	@Autowired
	private CommentsDao commentsDao;
	
	/*@PostMapping(path="/saveMedia")
	public String saveMedia(@RequestBody Media media) {
		
		mediadao.save(media);
		return "created: "+media.toString();
	}*/
	
	/*@PostMapping("/saveMedia")
	public String saveMedia(@RequestParam String title,@RequestParam String description,@RequestParam String tags, @RequestParam String effets, @RequestParam("img") MultipartFile file) {
		Media m =new Media();
		m.setTitle(title);
		m.setDescription(description);
		m.setEffets(effets);
		m.setTags(tags);
		byte[] imageData = null;
		try {
			imageData = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.setImg(imageData);
		mediadao.save(m);
		return "created: "+m.toString();
	}
	*/
	/*@RequestMapping("/upload")
	//public String upload(@RequestParam String title,@RequestParam String description,@RequestParam String tags, @RequestParam String effets, @RequestParam("img") MultipartFile file) {
	public String upload(@RequestParam String title,@RequestParam String description,@RequestParam String tags, @RequestParam String effets) {	
		return mediaservice.upload(title,description,tags,effets);
	}*/
	
	@PostMapping(path="/saveMedia")
	public String saveMedia(@RequestBody Media media) {
		System.out.println("media: "+media);
		media.setMediaURL("https://localhost:4200/assets/images/"+media.getMediaURL().substring(media.getMediaURL().lastIndexOf("\\")+1));
		media.setMimeType(media.getMediaURL().substring(media.getMediaURL().lastIndexOf(".")+1));
		mediadao.save(media);
		NewsFeed nf = new NewsFeed();
		nf.setMediaId(media.getMediaId());
		nf.setUserId(media.getUserid());
		nf.setActivity("you shared media image with title "+media.getMediaTitle());
		newsFeedDao.save(nf);
		return "created: "+media.toString();
	}
	
	@PostMapping(path="/saveMultiMedia")
	public String saveMultiMedia(@RequestBody List<Media> media) {
		System.out.println("in save multimedia"+media);
		for(Media media1:media) {
		mediadao.save(media1);
		NewsFeed nf = new NewsFeed();
		nf.setMediaId(media1.getMediaId());
		nf.setUserId(media1.getUserid());
		nf.setActivity("you shared media image with title "+media1.getMediaTitle());
		newsFeedDao.save(nf);
		
		}
		return "created: ";
	}
	
	
	@GetMapping("/getMedia")
	public List<Media> getMedia() {
		return (List<Media>) mediadao.findAll();
		
	}	
	
	@GetMapping("/myMedia")
	public List<Media> getMyMedia(@RequestParam String userid){
		return (List<Media>) mediadao.findByuserId(userid);
	}
	
	@GetMapping("/myMedia/{id}")
	public Media getMyMediaById(@PathVariable Integer id){
		return (Media) mediadao.findBymediaId(id);
	}
	
	@GetMapping("/myHiddenMedia/{hide}")
	public List<Media> getHideMedia(@PathVariable Boolean hide){
		return (List<Media>) mediadao.findByhide(hide);
	}
	
	
	@PostMapping(path="/updateMultiMedia")
	public String updateMultiMedia(@RequestBody Media media) {
		
		Media m = (Media) mediadao.findBymediaId(media.getMediaId());
		m.setMediaTitle(media.getMediaTitle());
		m.setDescription(media.getDescription());
		m.setEffects(media.getEffects());
		m.setHide(media.getHide());
		m.setMediaURL(media.getMediaURL());
		m.setMimeType(media.getMimeType());
		m.setTags(media.getTags());
		m.setMediaCaption(media.getMediaCaption());
		
		NewsFeed nf = new NewsFeed();
		nf.setMediaId(m.getMediaId());
		nf.setUserId(m.getUserid());
		nf.setActivity("you updated media of title "+m.getMediaTitle());
		newsFeedDao.save(nf);
		
		mediadao.save(m);
		return "created: ";
	}
	
	@PostMapping("/addComment/{newsFeedId}/{comment}/{userId}")
	public String addComment(@PathVariable Integer newsFeedId, @PathVariable String comment, @PathVariable String userId) {
		
		Comments coment = new Comments();
		coment.setComment(comment);
		coment.setUserId(userId);
		coment.setNewsFeedId(newsFeedId);
		commentsDao.save(coment);
		
		Media m = new Media();
		m=mediadao.findBymediaId(newsFeedId);
			int count = commentsCount(newsFeedId);
			m.setCommentsCount(count);
			mediadao.save(m);
			
			NewsFeed nf = new NewsFeed();
			nf.setMediaId(m.getMediaId());
			nf.setUserId(m.getUserid());
			nf.setActivity("you added comment to media of title "+m.getMediaTitle());
			newsFeedDao.save(nf);
		
		return "comment added";
	}
	
	@GetMapping("/getComment")
	public List<Comments> getComment(@RequestParam Integer mediaid) {
		return (List<Comments>) commentsDao.findByNewsFeedId(mediaid);
	}
	
	@PostMapping("/like/{userId}/{newsFeedId}")
	public Comments likePost(@PathVariable String userId, @PathVariable Integer newsFeedId) {
		Comments comment = commentsDao.findByUserIdAndNewsFeedId(userId, newsFeedId);
		Comments cmt = new Comments();
		if(comment!=null) {
		comment.setLike(!comment.getLike());
		commentsDao.save(comment);
		}
		else {
			cmt.setUserId(userId);
			cmt.setLike(true);
			cmt.setNewsFeedId(newsFeedId);
			commentsDao.save(cmt);
		}
		Media m = new Media();
		m=mediadao.findBymediaId(newsFeedId);
			int count = likesCount(newsFeedId);
			m.setLikesCount(count);
			mediadao.save(m);
		return cmt;
	}

	@PostMapping("/dislike/{userId}/{newsFeedId}")
	public Comments dislikePost(@PathVariable String userId, @PathVariable Integer newsFeedId) {
		Comments comment = commentsDao.findByUserIdAndNewsFeedId(userId, newsFeedId);
		Comments cmt = new Comments();
		if(comment!=null) {
			comment.setDislike(!comment.getDislike());
		commentsDao.save(comment);
		}
		else {
			cmt.setUserId(userId);
			cmt.setDislike(true);
			cmt.setNewsFeedId(newsFeedId);
			commentsDao.save(cmt);
		}
		
		Media m = new Media();
		m=mediadao.findBymediaId(newsFeedId);
			int count = dislikesCount(newsFeedId);
			m.setDislikesCount(count);
			mediadao.save(m);
		
		
		return cmt;
	}

	@GetMapping("/likesCount/{newsFeedId}")
	public Integer likesCount(@PathVariable Integer newsFeedId) {
		Integer count = commentsDao.countByNewsFeedIdAndLikes(newsFeedId,true);
		
		return count;
	}
	
	@GetMapping("/dislikesCount/{newsFeedId}")
	public Integer dislikesCount(@PathVariable Integer newsFeedId) {
		Integer count = commentsDao.countByNewsFeedIdAndDislike(newsFeedId,true);
		return count;
	}
	
	@GetMapping("/commentsCount/{newsFeedId}")
	public Integer commentsCount(@PathVariable Integer newsFeedId) {
		Integer count = commentsDao.countByNewsFeedIdAndCommentNotNull(newsFeedId);
		return count;
	}
	
	private static String UPLOADED_FOLDER = "C://FSD//Angular//pixogram//src//assets//images//";
	
	@PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("image") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
	    if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }
	
	@GetMapping("/getnewsfeed")
	public List<NewsFeed> getNewsFeed(@RequestParam String userid) {
		return (List<NewsFeed>) newsFeedDao.findByuserId(userid);
		
	}



}
