package pl.cbl.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.cbl.entity.Post;
import pl.cbl.entity.User;
import pl.cbl.repo.PostRepo;

@Controller
public class LogedController {
	
	@Autowired
	private PostRepo postR;
	
	
	@RequestMapping("/loged")
	public String home(HttpSession ses, Model m) throws IOException {	
		
		User logggedUser = (User)ses.getAttribute("loged");
		
		List<Post> list = postR.findByUserId(logggedUser.getId());
		
		m.addAttribute("name", logggedUser.getLogin());
		m.addAttribute("postList", list);
		
		return"loged";
	}
}


/*for(int i=0; i<list.size();i++) {
	Post post = list.get(i);
	String str = "http://www.omdbapi.com/?t="+post.getTitle();
	String str = "https://api.themoviedb.org/3/search/movie"
	URL url = new URL(str);		
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setRequestMethod("GET");
	conn.setRequestProperty("Accept", "application/json");

	if (conn.getResponseCode() != 200) {
		throw new RuntimeException("Failed : HTTP error code : "
				+ conn.getResponseCode());
	}

	BufferedReader br = new BufferedReader(new InputStreamReader(
		(conn.getInputStream())));
	filmy = br.toString();
	}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
			filmy = br.toString();
	*
	*
	*/



