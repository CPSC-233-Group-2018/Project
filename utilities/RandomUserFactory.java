package utilities;
import java.util.Random;

import users.Employer;
import users.Student;
import users.User;

/**Class that generates random Users*/
public class RandomUserFactory{

	/**Method that generates random User Variables that are used by all extended classes*/
	public static void generateRandomContactInfo(User u1) {

		u1.setFirstName(createRandomFirstName());
		u1.setEmail(createRandomEmail());
		u1.setCountry(createRandomCountry());
		u1.setLastName(createRandomLastName());
		u1.setPhoneNumber(createRandomPhoneNumber());
		u1.setProvince(createRandomProvinceState(u1));
		u1.setCity(createRandomCity(u1));
		u1.setAboutMe("I like long walks on the beach, and spending time in "+ u1.getCity() + ",the air is so nice in "+ u1.getCountry());

	}

	/**Method that generates a random Student and returns it*/
	public static Student generateRandomStudent() {
		Student randomStudent = new Student();
		generateRandomContactInfo(randomStudent);
		randomStudent.setUID(createRandomUIDNumber());
		randomStudent.setUniversity(createRandomUniversity(randomStudent));
		randomStudent.setProgramYear(createRandomYear());
		randomStudent.setGPA(createRandomGPA());
		randomStudent.setDegree(createRandomDegree());

		 if (randomStudent.getProgramYear() < 5){
			 randomStudent.setStudentType("Undergraduate Student");
		      }

		 if (randomStudent.getProgramYear() >= 5 && randomStudent.getProgramYear() < 8){
		     randomStudent.setStudentType("Masters Student");
		      }

		 if (randomStudent.getProgramYear() >= 8){
		     randomStudent.setStudentType("Doctoral Candidate");
		      }

		return randomStudent;


	}

	/**Method that creates a Random Employer and returns it*/
	public static Employer generateRandomEmployer() {
		Employer randomEmployer = new Employer();
		generateRandomContactInfo(randomEmployer);
		randomEmployer.setOfferingJobs("Yes");
		randomEmployer.setCompanyName(createRandomCompany());


		return randomEmployer;
	}

	//The code below is for creating contact info for random Users

	/** A method to create a random Fist Name*/
	public static String createRandomFirstName(){
	        Random rand = new Random();
	        String names[] = {"Nicola","Synthia","Hank","Antonietta","Melda","Aileen","Burton","Inge","Kurtis","Robbyn","Jerrold","Gena","Micha","Conchita","Hobert","Elissa","Towanda","Rubin","Elouise","Williams","Lurlene","Lacresha","Elodia","Calvin","Richie","Agnus","Drew","Sona","Fred", "Kitty", "Elon"};
	        String randomFullName = (names[(rand.nextInt(31))]);
	        return(randomFullName);
	}

	/** A method to create a random lastName*/
	public static String createRandomLastName(){
	        Random rand = new Random();
	        String names[] = {"Racine","Mershon","Carboni","Chambers","Kimmer","Agron","Hemingway","Fort","Popham","Hutto","Berrios","Moniz","Erb","Holtzman","Cawley","Hogge","Merideth","Landis","Chance","Losee","Merrihew","Mackey","Fischbach", "Caouette","Esterly","Collman","Wolfe","Orme","Whelan", "Royals"};
	        String randomFullName = (names[(rand.nextInt(30))]);
	        return(randomFullName);
	}

	/** A method to create a random Company Name*/
	public static String createRandomEmail(){
	        Random rand = new Random();
	        String names[] = {"mthurn@live.com", "fangorn@hotmail.com","euice@outlook.com","rgarcia@optonline.net","mxiao@yahoo.com", "firstpr@att.net","webdragon@comcast.net", "jguyer@aol.com", "sakusha@yahoo.ca","crandall@sbcglobal.net","drezet@me.com", "miyop@icloud.com"};
	        String randomEmail = (names[(rand.nextInt(11) + 1)]);
	        return(randomEmail);
	}

	/** A method to create a random Country Name*/
	public static String createRandomCountry(){
	        Random rand = new Random();
					double choice = rand.nextDouble();
					if (choice > 0.5){
						return "Canada";
					}
					else{
						return "USA";
					}
	}

	/** A method to create a random Phone number*/
	public static String createRandomPhoneNumber(){
	        Random rand = new Random();
	        String names[] = {"(403)251-1234 ", "(403)679-1234","(403)382-1234","(403)765-1234", "(403)257-3124"};
	        String randomPhoneNumber = (names[(rand.nextInt(4) + 1)]);
	        return(randomPhoneNumber);
	}

	/** A method to create a random Province/State*/
	public static String createRandomProvinceState(User u1){
	        Random rand = new Random();
	        String randomProvinceState = null;
	        if(u1.getCountry().equals("Canada")) {
	        	String names[] = {"Alberta", "British Columbia", "Manitoba", "New Brunswick", "Newfoundland and Labrador", "Nova Scotia", "Ontario", "Prince Edward Island", "Quebec", "Saskatchewan"};
    			randomProvinceState = (names[(rand.nextInt(9))]);
	        }

	        if(u1.getCountry().equals("USA")) {
	        	String names[] = {"California", "Alabama", "Arkansas", "Arizona", "Alaska", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" };
	        	randomProvinceState = (names[(rand.nextInt(49))]);
	        }


	        return(randomProvinceState);
	}

	/** A method to create a random City based on State/Province*/
	public static String createRandomCity(User u1){
	        Random rand = new Random();
	        String randomCity = null;
	        switch(u1.getProvince()) {

	        	//Canadian Provinces
	        	case "Alberta":
	        		 String Alberta[] = {"Calgary", "Edmonton", "Lethbridge"};
	    	         randomCity= (Alberta[(rand.nextInt(2))]);
	        		break;

	        	case "British Columbia":
	        		 String BC[] = {"Surrey", "Vancouver", "Revelstoke"};
	    	         randomCity= (BC[(rand.nextInt(2))]);
	        		break;

	        	case "Manitoba":
	        		 String Manitoba[] = {"Selkirk", "Flin Flon", "Churchill"};
	    	         randomCity= (Manitoba[(rand.nextInt(2))]);
	        		break;

	        	case "New Brunswick":
	        		 String NB[] = {"Hartland", "Bathurst", "Edmundston"};
	    	         randomCity= (NB[(rand.nextInt(2))]);
	        		break;

	        	case "Newfoundland and Labrador":
	        		 String NL[] = {"Deer Lake", "Gander", "Corner Brook"};
	    	         randomCity= (NL[(rand.nextInt(2))]);
	        		break;

	        	case "Nova Scotia":
	        		 String NS[] = {"Halifax", "Digby", "Pictou"};
	    	         randomCity= (NS[(rand.nextInt(2))]);
	        		break;

	        	case "Ontario":
	        		 String Ontario[] = {"Kingston", "Mississauga", "Waterloo"};
	    	         randomCity= (Ontario[(rand.nextInt(2))]);
	        		break;

	        	case "Prince Edward Island":
	        		 String PEI[] = {"Charlottetown", "Kensington", "Stratford"};
	    	         randomCity= (PEI[(rand.nextInt(2))]);
	        		break;


	        	case "Quebec":
	        		 String Quebec[] = {"Montreal", "Granby", "Amos"};
	    	         randomCity= (Quebec[(rand.nextInt(2))]);
	        		break;

	        	case "Saskatchewan":
	        		 String Saskatchewan[] = {"Saskatoon", "Moose Jaw", "Prince Albert"};
	    	         randomCity= (Saskatchewan[(rand.nextInt(2))]);
	        		break;

	        	//US States, all set to capitals of states


					case "North Carolina":
					randomCity= "Raleigh";
					break;

					case "California":
					randomCity = "Los Angeles";
					break;

					case "Alabama":
					randomCity = "Montgomery";
					break;

					case "Arkansas":
					randomCity = "Little Rock";
					break;

					case "Arizona":
					randomCity = "Phoenix";
					break;

					case "Alaska":
					randomCity = "Juneau";
					break;

					case "Colorado":
					randomCity = "Denver";
					break;

					case "Connecticut":
					randomCity = "Hartford";
					break;

					case "Delaware":
					randomCity = "Dover";
					break;

					case "Florida":
					randomCity = "Tallahassee";
					break;

					case "Georgia":
					randomCity = "Atlanta";
					break;

					case "Hawaii":
					randomCity = "Honolulu";
					break;

					case "Idaho":
					randomCity = "Boise";
					break;

					case "Illinois":
					randomCity = "Springfield";
					break;

					case "Indiana":
					randomCity = "Indianapolis";
					break;

					case "Iowa":
					randomCity = "Des Moines";
					break;

					case "Kansas":
					randomCity = "Topeka";
					break;

					case "Kentucky":
					randomCity = "Frankfort";
					break;

					case "Louisiana":
					randomCity = "Baton Rouge";
					break;

					case "Maine":
					randomCity = "Augusta";
					break;

					case "Maryland":
					randomCity = "Annapolis";
					break;

					case "Massachusetts":
					randomCity = "Boston";
					break;

					case "Michigan":
					randomCity = "Lansing";
					break;

					case "Minnesota":
					randomCity = "St. Paul";
					break;

					case "Mississippi":
					randomCity = "Jackson";
					break;

					case "Missouri":
					randomCity = "Jefferson City";
					break;

					case "Montana":
					randomCity = "Helena";
					break;

					case "Nebraska":
					randomCity = "Lincoln";
					break;

					case "Nevada":
					randomCity = "Carson City";
					break;

					case "New Hampshire":
					randomCity = "Concord";
					break;

					case "New Jersey":
					randomCity = "Trenton";
					break;

					case "New Mexico":
					randomCity = "Santa Fe";
					break;

					case "New York":
					randomCity = "Albany";
					break;

					case "North Dakota":
					randomCity = "Bismarck";
					break;

					case "Ohio":
					randomCity = "Columbus";
					break;

					case "Oklahoma":
					randomCity = "Oklahoma City";
					break;

					case "Oregon":
					randomCity = "Salem";
					break;

					case "Pennsylvania":
					randomCity = "Harrisburg";
					break;

					case "Rhode Island":
					randomCity = "Providence";
					break;

					case "South Carolina":
					randomCity = "Columbia";
					break;

					case "South Dakota":
					randomCity = "Pierre";
					break;

					case "Tennessee":
					randomCity = "Nashville";
					break;

					case "Texas":
					randomCity = "Austin";
					break;

					case "Utah":
					randomCity = "Salt Lake City";
					break;

					case "Vermont":
					randomCity = "Montpelier";
					break;

					case "Virginia":
					randomCity = "Richmond";
					break;

					case "Washington":
					randomCity = "Olympia";
					break;

					case "West Virginia":
					randomCity = "Charleston";
					break;

					case "Wisconsin":
					randomCity = "Madison";
					break;

					case "Wyoming":
					randomCity = "Cheyenne";
					break;
				}

	        return(randomCity);
	}


	//Code below is for generating random Student Attributes

    /** A method to create a random UID #*/
    public static String createRandomUIDNumber(){
      Random rand = new Random();

      int n = (30000000 + rand.nextInt(900000) + 1);
      String randomUID = Integer.toString(n);
      return(randomUID);
    }

    /** A method to create a random University*/
    public static String createRandomUniversity(User u1){
      Random rand = new Random();
      String randomUniversity = null;
			switch(u1.getCountry()){
				case "Canada":
				String CanadianUniversities[] = {"University of Calgary","University of Lethbridge","SAIT","University of Waterloo","Athabasca University", "McGill University", "University of Toronto", "University of British Columbia", "University of Alberta", "McMaster University"};
				randomUniversity =  (CanadianUniversities[(rand.nextInt(9))]);
				break;

				case "USA":
				String USUniversities[] = {"University of Chicago","Boston University", "University of Vegas", "MIT", "Princeton University", "Harvard University", "Yale University", "Columbia University", "Stanford University","University of Pennsylvania" };
				randomUniversity =  (USUniversities[(rand.nextInt(9))]);
				break;
			}
      return(randomUniversity);
    }

    /** A method to create a random Year*/
    public static int createRandomYear(){
      Random rand = new Random();
      int n = (rand.nextInt(7)+1);
      return(n);
    }

    /** A method to create a random GPA*/
    public static double createRandomGPA(){
      double rangeMin = 2.0;
      double rangeMax = 4.0;
      Random rand = new Random();
      double n = rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
      return(n);
    }

    /** A method to create a random Degree*/
    public static String createRandomDegree(){
      Random rand = new Random();
      String names[] = {"CPSC","BIO", "MED", "ENG", "SOCI", "PSYC", "COMM",  "CMF", "LING"};
      String randomDegree = (names[(rand.nextInt(8))]);
      return(randomDegree);
    }


  //Code below is for generating random Employer Attributes


    /** A method to create a random Company Name*/
    public static String createRandomCompany(){
      Random rand = new Random();
      String names[] = {"Driive","Google","Rosignol","Nike","Addidas","Audi","Tesla","Enmax","the futur","Coca-Cola","Mcdonalds","Taco Time","Blind Studios","Blizzard","Electronic Arts","Apple","American Eagle","Bootlegger","Walmart","Helly Hansen","University of Calgary","Bob's Burgers","Microsoft","North Face","Samsung","Sandisk","Intel","AMD","ASUS", "Gigabyte"};
      String randomCompany = (names[(rand.nextInt(29))]);
      return randomCompany;
    }
}
