package com.lebab.datumbox;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lebab.datumbox.form.FormData;
import com.lebab.datumbox.service.intf.HitApiService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static String HOME = "home";
	private static String MV_SHOW = "show";

	@Autowired
	private HitApiService hitApiService;
	
	@Autowired
	private AppConfig config;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) throws IOException {
		model.addAttribute("formData", new FormData());
		
		return HOME;
	}
	 @RequestMapping(value = "/show", method = RequestMethod.POST)
	    public String responseAPI(@ModelAttribute("formData") FormData formData, BindingResult  result, Model model) throws IOException {
	       
		 String urlParameters = "api_key=" + config.getApi_key() + "&text=" + formData.getRequestText();
			String request = config.getUrl();
			URL url = new URL(request);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			logger.debug("Sending reqeuest to datumbox");
			InputStream inptStrm = hitApiService.postURL(connection, url, urlParameters, request);
			String jsonTxt = IOUtils.toString(inptStrm);
			String responseData = parse(jsonTxt).replace("\"", "");
			
			model.addAttribute("response", responseData);
	        return MV_SHOW;
	    }
	 
	 public String parse(String jsonLine) {
		    JsonElement jelement = new JsonParser().parse(jsonLine);
		    JsonObject  jobject = jelement.getAsJsonObject();
		    jobject = jobject.getAsJsonObject("output");
		    String result = jobject.get("result").toString();
		    return result;
		}
	 /*
	  * You can use and the following URLs that datumbox offers
	  * request = "http://api.datumbox.com/1.0/SentimentAnalysis.json";
		request = "http://api.datumbox.com/1.0/TwitterSentimentAnalysis.json";
		request = "http://api.datumbox.com/1.0/SubjectivityAnalysis.json";
		request = "http://api.datumbox.com/1.0/TopicClassification.json";
		request = "http://api.datumbox.com/1.0/SpamDetection.json";
		request = "http://api.datumbox.com/1.0/AdultContentDetection.json";	
		request = "http://api.datumbox.com/1.0/ReadabilityAssessment.json ";	
		request = "http://api.datumbox.com/1.0/LanguageDetection.json";	
		request = "http://api.datumbox.com/1.0/CommercialDetection.json";
		request = "http://api.datumbox.com/1.0/EducationalDetection.json";
		request = "http://api.datumbox.com/1.0/GenderDetection.json";
		request = "http://api.datumbox.com/1.0/KeywordExtraction.json";
		request = "http://api.datumbox.com/1.0/TextExtraction.json";
		request = "http://api.datumbox.com/1.0/KeywordExtraction.json";
		request = "http://api.datumbox.com/1.0/KeywordExtraction.json";
	  */
}
