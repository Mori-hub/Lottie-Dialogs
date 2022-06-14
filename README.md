
# Lottie Dialoges

This is kind of a dialog. This includes Lottie animations in two  different sizes.
## Features

- lottie animation
- Support all languages
- Unlimited call fuctions
- Easy Use
- All Dialoges: Welcome, Exit, Warning, Info, Delete, Success
- Easy Theme 
- Custom Dialog


## Installation

Install my-project with https://jitpack.io/ 


```bash
  dependencies {
	          implementation 'com.github.Mori-hub:Lottie-Dialogs:1.0.0'
	}
```
## Version 

<img alt="JitPack" src="https://img.shields.io/jitpack/v/github/Mori-hub/Lottie-Dialogs">

## Usage

```javascript
    // Call Lib (Small or Large)
        val lottieHeader = LottieHeader(this, "large")
    // Main Way
        lottieHeader.welcome(description: String,
                    titleOfPositiveButton: String? = null,     
                    positiveButtonFunction: (() → Unit)? = null )
```
## Explain
* **ButtonFunction** : Here you can add your Unit, Method or Calss. (such as Toast)
* **null** : For any attributes you can put null then use defualt
* **Show Dialog**: When you call any method this will show, so please ues in side OnClick. 
* **Colors**: A color must be a name ("yellow") or a Hex code ("#DFD3C3") 
## Examples
```javascript
        // Welcome Dialog
        findViewById<Button>(R.id.button).setOnClickListener {
            lottieHeader.welcome("Hi, Welcome to our app! 😎")
        }
        // Exit Dialog
        findViewById<Button>(R.id.button2).setOnClickListener {
            lottieHeader.exit(
                "Goodbye, \n Do you want Exit now?",
                null, null, null, this
            )
        }
        // Rate Dialog
        findViewById<Button>(R.id.button3).setOnClickListener {
            lottieHeader.rate("Hi, Please Rate us! 😎", null, null, null)
        }
        // Information Dialog
        findViewById<Button>(R.id.button4).setOnClickListener {
             lottieHeader.info("This is an App just show Information! 😎", "info",
                { Toast.makeText(this, "Help me", Toast.LENGTH_SHORT).show() })
        }
        // Warning Dialog
        findViewById<Button>(R.id.button5).setOnClickListener {
            lottieHeader.warning("Attention, this is yellow area!", null, null, null)

        }

        // Delete Dialog
        findViewById<Button>(R.id.button6).setOnClickListener {
            lottieHeader.del("Do you want delete this file?", null, null, null)

        }

        // Success Dialog
        findViewById<Button>(R.id.button7).setOnClickListener {
            lottieHeader.success("The process is successful!", null, null, null)

        }

```
## Sample 

```javascript
    // Editable Dialog
     lottieHeader.sample(
                "file.json",
                "#DFD3C3", "This is a sample you can generate as you want",
                "Got it", "Not Sure", "Help me ",
                "green", "red", "yellow", "black",
                { Toast.makeText(this, "Got", Toast.LENGTH_SHORT).show() },
                { Toast.makeText(this, "Not", Toast.LENGTH_SHORT).show() },
                { Toast.makeText(this, "Help me", Toast.LENGTH_SHORT).show() }
            )
```

## Optinal Theme 

```javascript
    // You set theme for all dialoges 
    lottieHeader.dialogTheme(
            false,
            "black",
            "gray", "white",
            "#9B0000", "yellow"
        )
```
## Screenshots

Large Mode

<img src="https://user-images.githubusercontent.com/53067774/160883315-41ac27d0-0c45-4eea-a741-c6799bdaef34.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160883337-5c2b3287-486a-4d6f-a032-f69dc0c13020.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160883352-33be1ccc-2305-4a83-8e73-48f25fb32010.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160883362-7653417c-9402-46ec-9d3b-8edeb1e11721.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160883400-d576aeb6-8021-4105-bfbf-6a3ca065dafe.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160883412-3649f212-f340-48f8-9197-390d8c708d27.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160883431-c985849b-eabf-4d09-81e7-66db09b8e23d.jpg" width="13%"></img> 

Small Mode

<img src="https://user-images.githubusercontent.com/53067774/160883954-04e0cc17-fe32-4036-be60-4fb52e629cc0.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160883963-e584eed3-c507-4929-8d48-30d9f7ebb226.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160883973-4b1c4a37-1ba7-4c89-b680-cbd6f5cb8c69.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160883983-76ecac58-df76-4e05-9522-39304b80faef.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160883993-a2c6bc01-323a-4b47-a41f-28dae5683d0d.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160884005-bef4960f-1c85-40e8-818e-f0abefc509ec.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160884018-2aff51a9-792d-43bf-b47b-90bdf673d3f5.jpg" width="13%"></img> 

Custom Mode

<img src="https://user-images.githubusercontent.com/53067774/160884438-bd161fee-897b-4981-ac3f-e1b19679d81b.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160884451-681ef066-71cc-4584-9ec3-ed0c66f0d7d1.jpg" width="13%"></img> 

Apply Black Theme

<img src="https://user-images.githubusercontent.com/53067774/160884621-37cbad2f-784b-413d-93df-ceea08f6ab4c.jpg" width="13%"></img> <img src="https://user-images.githubusercontent.com/53067774/160884639-8a96dcdf-07d4-4272-bd70-ebb910d43c5f.jpg" width="13%"></img> 

## Gifs

<img src="https://user-images.githubusercontent.com/53067774/160893850-2ae73874-8264-4773-9f72-7327b4664d81.gif" width="15%"></img> <img src="https://user-images.githubusercontent.com/53067774/160893931-d09309d7-6d5a-4a43-afe8-5d1287e95a87.gif" width="15%"></img> <img src="https://user-images.githubusercontent.com/53067774/160894022-3e3dcdcf-87ef-4268-9ffb-51d03287d221.gif" width="15%"></img> <img src="https://user-images.githubusercontent.com/53067774/160894172-b8b7ec27-a062-48ea-abb9-8e4ea564d69f.gif" width="15%"></img> 

## 🚀 About Me
I'm a full stack developer...find me in google play store


## 🛠 Skills
Java, Kotlin, CSS....


## Tech Stack

**Important:** For Gradle 7.2 & jitpack.io Please use this way : https://stackoverflow.com/a/71603699/12272687

**Update:** March 2022


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Mori-hub)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/)
[![Google](https://img.shields.io/badge/My%20Apps-Google%20Play%20Store-green?style=for-the-badge&logo=googleplay)](https://play.google.com/store/search?q=pub:Smart%20rabit&c=apps)


## Feedback

If you have any feedback, please reach out to us at SR-App@outlook.com


## License

[MIT](https://choosealicense.com/licenses/mit/)

