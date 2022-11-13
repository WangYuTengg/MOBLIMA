# MOBLIMA - MOvie Booking and LIsting Management Application
## Introduction 
> *The assignment for your group will be to design and develop a Console-based application (non-Graphical UI): MOBLIMA is an application to computerize the processes of making online booking and purchase of movie tickets, listing of movies and sale reporting. It will be used by the moviegoers and cinema staff.*

## How to run application:
* git clone repository into your machine
* ensure java dependencies are installed (JDK, JVM etc.)
* in MoblimaApp.java:
```
  	public static void main(String[] args) {
		MainMenuUi mainMenuUI = new MainMenuUi();
		Database db; 
		db = DataInitialiser.main(); //uncomment this for first run of program, comment it out for subsequent runs
		//db=Serialization.read(); //uncomment this for 2nd run onwards
		mainMenuUI.main(db);
		Serialization.write(db);
	}
```
* Follow instructions in the comments and run code from MoblimaApp.java.
* Admin login -> admin1@gmail.com (email) , admin123 (password) 
* Moviegoer login -> JohnTan@gmail.com (email), abc123 (password) or create a new account.

## Repository content: 

## Challenges and lessons learnt:
*
*
*

## Contributors:
* Wang Yu Teng [@WangYuTengg](https://github.com/WangYuTengg)
* Ng Yong Jian [@ngyongjian](https://github.com/ngyongjian)
* Guo Sihan [@GuoSihan0320](https://github.com/GuoSihan0320)
* Davyn Yam Junhao [@Davynyam](https://github.com/Davynyam)
* Pugalia Aditya Kumar [@AdityaPugalia](https://github.com/AdityaPugalia)
