Import as maven project 
Deploy the project to tomcat
Open URL : http://localhost:port/datumBoxSpringMVC/ i.e: http://localhost:8080/datumBoxSpringMVC/
There are  properties messages.properties (resources folder), to include in your jsp
Also you have to create a property file defined here:/datumBoxSpringMVC/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml
You give a path (even outside war) and loads automatically the two main parameters api_key and datumbox.url (i.e C:/apache-tomcat-6.0.37/conf/datumbox/datumbox.properties)


You can use and the following URLs that datumbox offers
	    datumbox.url = "http://api.datumbox.com/1.0/SentimentAnalysis.json";
		datumbox.url = "http://api.datumbox.com/1.0/TwitterSentimentAnalysis.json";
		datumbox.url = "http://api.datumbox.com/1.0/SubjectivityAnalysis.json";
		datumbox.url = "http://api.datumbox.com/1.0/TopicClassification.json";
		datumbox.url = "http://api.datumbox.com/1.0/SpamDetection.json";
		datumbox.url = "http://api.datumbox.com/1.0/AdultContentDetection.json";	
		datumbox.url = "http://api.datumbox.com/1.0/ReadabilityAssessment.json ";	
		datumbox.url = "http://api.datumbox.com/1.0/LanguageDetection.json";	
		datumbox.url = "http://api.datumbox.com/1.0/CommercialDetection.json";
		datumbox.url = "http://api.datumbox.com/1.0/EducationalDetection.json";
		datumbox.url = "http://api.datumbox.com/1.0/GenderDetection.json";
		datumbox.url = "http://api.datumbox.com/1.0/KeywordExtraction.json";
		datumbox.url = "http://api.datumbox.com/1.0/TextExtraction.json";
		datumbox.url = "http://api.datumbox.com/1.0/KeywordExtraction.json";
		datumbox.url = "http://api.datumbox.com/1.0/KeywordExtraction.json"; 