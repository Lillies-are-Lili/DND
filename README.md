# finalproject

## Synopsis

Embark on a journey into a world of endless possibilities with DND Name Generator, the ultimate Dungeons & Dragons character generation! Unleash your creativity and bring your characters to life with a tool that goes beyond mundane names. Elevate your gaming experience with our unique dice roll feature, allowing you to pick a specific number-sided die and even add proficiency, advantage or disadvantage, for an extra layer of spontaneity. Dive into a rich tapestry of fantasy realms as you effortlessly generate unique and immersive names for races, backgrounds, creatures, and more. One can also notate and keep all of their characters that they generate. Reveal the power of words and forge a connection between your players and the fantastical realms they inhabit. DND Name Generator is not just a name generator; it's a key to unlocking the immersive potential of your Dungeons & Dragons adventures. Elevate your storytelling and embark on a quest of boundless creativity today!

## A look into our application! 
<img width="205" alt="Screen Shot 2023-11-30 at 8 35 06 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/c15f80d3-4048-473f-b39d-b600e73a7588">


## Code Example

For example, we have added CSV files detailing the various characteristics to our assets folder, and have methods that read in the files and randomly generate a characteristic for your character.


/**
*This method generates a background for your character
*/
     
     public void loadBackground(Context context) throws IOException {
        AssetManager asset = context.getAssets();
        // Open the background file from the assets folder
        try {
            InputStream is = asset.open("Background.csv");
            // Read the file using a Scanner
            Scanner scan = new Scanner(is);
            Random rand = new Random();
            // Store each line of the file in an ArrayList
            ArrayList<String> temp = new ArrayList<>();
            while(scan.hasNextLine()) {
                temp.add(scan.nextLine());
            }
            // Randomly select a background from the list
            finalBack = temp.get(rand.nextInt(temp.size()-1));
            // Handle IO exception
        } catch(IOException e) {
            System.out.println("Failed background IO");
        }
    }
    

## Motivation

A Dungeons & Dragons name generator is an essential tool for Dungeon Masters and players, elevating the gaming experience by offering instant inspiration and thematic names for characters, cities, and items. Ensuring world-building consistency, the generator provides linguistic diversity reflective of various cultures. Its versatility spans different facets of the game, preventing name repetition and saving time during dynamic sessions. Offline accessibility further enhances its utility, making it an indispensable resource for crafting immersive narratives and fostering creativity in D&D adventures.

## Installation

Please ensure you have Android Studio downloaded onto your local computer.
To gain access to the code, all one needs to do is visit this link provided here: https://github.com/UTSA-CS-3443/DND . Then, you can click the green "<>code"<img width="98" alt="Screen Shot 2023-11-30 at 8 40 54 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/d7f54589-e291-4c9d-afa7-2bb5a3f75c6d">
 button and click "Download ZIP" to begin the download of the application onto your local computer. Then you can open the application on Android Studio, and click the Device Manager button on the top right.<img width="31" alt="Screen Shot 2023-11-30 at 8 37 24 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/006dab1a-df16-406b-9870-f2bea440ad06">
 Click the large "Create Device" button,<img width="399" alt="Screen Shot 2023-11-30 at 8 39 07 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/988d5a5b-2b49-45de-b079-a21b75c5ecbb">
 and choose a device to have the application on. For the system image, you must pick the Oreo release name, with an API level of 26. This ensures the application will work on the device. Click "Next", and then click "Finish". This will create an Android Virtual Device, and then you are able to run the application on this AVD. On the top right, to the left of the Device Manager button, is the "sync Project with Gradle Files" button.<img width="33" alt="Screen Shot 2023-11-30 at 8 37 29 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/6fd0167f-9cce-4dd7-bb80-2729ac4135c1">
 Please click the button and allow the IDE a few minutes to sync the project. Once the sync is complete, can you run the application! Click the green arrow in the middle to run the application.<img width="28" alt="Screen Shot 2023-11-30 at 8 42 21 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/c7238153-e0a2-4711-b9f2-657335a5cc82">
 All the required data and documentation are already within the project, therefore no other downloads are required to begin this application. And there you have it! A working character generator with backgrounds, jobs, races, different-sided die, level and advantage drop-downs, notes, and proficiency toggles. 

## Instruction


When the application loads you are set on the welcome screen. From here, you may choose what you want to do with the application. From generating a random character, to picking the proficiency and advantage levels that you may possess. To go back from a view back to the main page, you can just click the back button on the Android Virtual Device.

### Name View
If you click on "Generate Name", it will take you to our Name View, in which you will be presented with three more buttons, a spinner (also known as a drop-down menu) and a TextView box that will print your randomly generated items. If you click "Generate Job!", a random job from our CSV file, containing more than 120 different jobs in the world of DND, will populate in the TextView box. If the job you were given is not to your liking, you can click the button again for another randomly generated job! The button right below is the "Generate Background!" button. Similar to the job button, clicking this button will populate a random background from our CSV files, and print on the TextView. The spinner below, when clicked, will present the user with a variety of different races that are present in DND. From elves to goliaths, you can choose whichever race you want your character to be! Then next button is the "Generate Character Name!" button. This will generate a random first name, and a random last name and concatenate them together. The race you chose from the spinner, will also populate with your given name. 

### Dice View
If you click the "Dice Roll" button, this will take you to the Dice View. From here, you are presented with three spinners, a toggle button, an EditText, a button, a TextView and a TableLayout. The first spinner called "Select Dice" at the very top, is the dice spinner. You are able to select whichever sided die you want. If you do not see a certain sided die that you want, there is an EditText to the bottom left, called "Custom Modifier" which allows you to input a number for the sided die you want. There is a "PROFICIENCY" toggle to the right of the Dice spinner, and you are able to pick between a proficient or not proficient level. To the other side is the "Select Level" spinner where you can specifiy what level you want your proficiency level to be at. Then, below the proficiency toggle is the Advantage spinner. Here, you're able to select whether you want an advantage or not when it came to the dice roll. Then, after each spinner and toggle is chosen, can the user click the "roll" button. This will roll the die and give you a randomly generated roll number, with the specifications applied to the die. You are also able to see the previous rolls in the TableLayout as well. The TextView will also display the result of the roll. 

### Notes View
Then we have the "Notes" button, where you're presented with three buttons, two EditTexts, a Scrollview, and a Spinner. Here is where you will type in and save your notes for your characters, your dice, anything you like, for later use. There are two EditTexts, with hints informing the user where to put their data and what it will represent. For example, the Title EditView has a hint informing the user that this will be the title of the note. Then, below that is the body of the note, which is where the user will type in the rest of their note. The "Push" button saves the note to the Spinner at the top, which is where the notes and their titles will populate. The "Smite" button deletes a note that you had saved, and you can specify which note to delete by clicking the spinner at the top. The "Pull" button will pull a note that you specified from the spinner, and print the contents of the note in the ScrollView. 

### Credit View
This is a simple view with TextViews that display the authors of this application. 

### Exit Button
Clicking this button exits the application. 


## API Reference

* Java: https://docs.oracle.com/javase/8/docs/api/
* Adobe Experience Manager: https://developer.adobe.com/experience-manager/reference-materials/6-5/javadoc/com/day/cq/dam/api/AssetManager.html
* Android Studio: https://developer.android.com/reference/packages

## Tests

* This method takes in the two randomly selected last name, and first name, and concatenates them together. While in the Name view, there is a spinner that allows the user to pick the race they desire. Whatever race they pick, will populate with the name generated. 
 
       public void onClick(View view) {
        text.setText("");
        //boolean arguments here for the switches
        //spinner.getSelectedItem().toString(); ->returns the value that the spinner is currently selected as a string
        if(view.getId() == R.id.generate) {
            try {
                cn.loadCharacter(this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            text.setText(getName() + ", " + spinner.getSelectedItem().toString());
        }
        else if(view.getId() == R.id.backGenerate){
            try {
                back.loadBackground(this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            text.setText(getBack());
        }
        else if(view.getId() == R.id.jobGeneration) {
            try {
                job.loadJobs(this);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            text.setText(getJob());
        }
      }

* Similar to the method in the Code Example at the top of the README, this method scans in the jobs from the provided CSV files, and randomly picks one to be printed to the screen when the user clicks the appropriate button in the Name view. 
  
         public void loadJobs(Context context) throws IOException {
        AssetManager asset = context.getAssets();
        // Open the job file from the assets folder
        InputStream is = asset.open("Job.csv");
        Scanner scan = new Scanner(is);
        Random rand = new Random();

        ArrayList<String> jobselector = new ArrayList<>();
        // Populate the ArrayList with job options from the CSV file
        while (scan.hasNextLine()) {
            jobselector.add(scan.nextLine());
        }
        // Randomly select a job from the loaded options
        int jobModVal = rand.nextInt(jobselector.size()-1);

        finalJob = jobselector.get(jobModVal);
        // Clear the ArrayList to release memory
        jobselector.clear();
      }
  
* This method returns the text that the user saved in the Notes view.  

         public String getText(int indexOf) {
        String str = "";
        try {
            FileReader reader = new FileReader(listOfFiles[indexOf]);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while (true) {
                try {
                    if (!((line = bufferedReader.readLine()) != null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                str = str + line;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return str;
      }

* This method finds a file and if the file exists, updates the file to what the user wants, but if it doesn't exist, then creates the file.
  
      public void setfile(String ttl, String text) {
        File temp = new File(activity.getApplicationContext().getFilesDir().toString() + "/notes/" + ttl);
        FileWriter writer = null;
        if(!temp.exists()){
            try {
                temp.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            writer = new FileWriter(temp);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      }


* This method first checks if a dice was selected, and then if a proficiency toggle was checked. If both were, if the advantage spinner was set to advantage, if roll1 was bigger than roll2, display roll1. If disadvantage was chosen, then if roll1 is bigger then roll2, display roll2.

          @Override
            public void onClick(View v) {
                if(diceSelect() != 0) {
                    if ((proficiencyToggle.isChecked() && !"Select Level".equals(levelDropDownSpinner.getSelectedItem().toString())) || !proficiencyToggle.isChecked()) {
                        args = argBuilder();
                        String temp;
                        if (advantageSpinner.getSelectedItem().toString() == "Advantage") {
                            int roll1 = choice.roll(args, diceSelect());
                            int roll2 = choice.roll(args, diceSelect());
                            if (roll1 >= roll2) {
                                temp = Integer.toString(roll1);
                            } else {
                                temp = Integer.toString(roll2);
                            }
                        } else if (advantageSpinner.getSelectedItem().toString() == "Disadvantage") {
                            int roll1 = choice.roll(args, diceSelect());
                            int roll2 = choice.roll(args, diceSelect());
                            if (roll1 >= roll2) {
                                temp = Integer.toString(roll2);
                            } else {
                                temp = Integer.toString(roll1);
                            }
                        } else {
                            temp = Integer.toString(choice.roll(args, diceSelect()));
                        }
                        resultDisplay.setText("Result: " + temp);
                        addRoll(Integer.valueOf(temp));
                        choice.reset();
                        args.clear();
                    } else {
                        Toast.makeText(DiceActivity.this, "Please select a level for proficiency bonus!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DiceActivity.this, "Please select a Dice!", Toast.LENGTH_SHORT).show();
                }
            }
           });
       }


* This method returns whichever sided die the user picked

         private int diceSelect() {
        String select = diceSelectSpinner.getSelectedItem().toString();
        int toReturn = 0;
        switch (select) {
            case ("D3"):
                toReturn = 3;
                break;
            case ("D4"):
                toReturn = 4;
                break;
            case ("D6"):
                toReturn = 6;
                break;
            case ("D8"):
                toReturn = 8;
                break;
            case ("D10"):
                toReturn = 10;
                break;
            case ("D12"):
                toReturn = 12;
                break;
            case ("D20"):
                toReturn = 20;
                break;
            default:
                System.out.println("ERROR DICE SWITCH");
                break;
        }
        return toReturn;
    }


*This method goes through each of the buttons on the Notes view. If the user clicks pull, and pull is empty, it returns a toast that there are no files saved. If there are files that are saved, then to return the contents of the note. If the user clicks push, then the method will save the title and body of the note into an ArrayAdapter object. If the user clicks SMITE, then the method will delete the specified note. 

         public void onClick(View view) {
        if (view.getId() == R.id.Pull) {
            // Handle Pull button click
            if (noteNames.isEmpty()) {
                Toast.makeText(this, "YOU HAVE NO MORE FILES TO PULL", Toast.LENGTH_SHORT).show();
            } else {
                // Set text fields with selected note content
                tile.setText(spinner.getSelectedItem().toString());
                body.setText(notes.getText(noteNames.indexOf(spinner.getSelectedItem().toString())));
                Toast.makeText(this, "Hurrah", Toast.LENGTH_SHORT).show();
            }
        } else if (view.getId() == R.id.Push) {
            // Handle Push button click
            String ttl = String.valueOf(tile.getText());
            String text = String.valueOf(body.getText());
            notes.setfile(ttl, text);
            notes.loadNotes();
            noteNames = notes.getnames();
            ArrayAdapter adapter = new ArrayAdapter(this, R.layout.custom, noteNames.toArray());
            spinner.setAdapter(adapter);
        } else if (view.getId() == R.id.Destroy) {
            // Handle Destroy button click
            if (noteNames.isEmpty()) {
                Toast.makeText(this, "YOU HAVE NO MORE FILES TO SMITE", Toast.LENGTH_SHORT).show();
            } else {
                // Remove the selected note and update the UI
                notes.smiteFile(noteNames.indexOf(spinner.getSelectedItem().toString()));
                notes.loadNotes();
                noteNames = notes.getnames();
                ArrayAdapter adapter = new ArrayAdapter(this, R.layout.custom, noteNames.toArray());
                spinner.setAdapter(adapter);
            }
        }
    }

## Contributors

The DND Name Generator will be open for improvement after Dec 1st, 2023. Started off as a group project among four aspiring software developers, will soon have the availability to be an open source project among anyone who wishes to work on it. 
We will have all of our updates for the project on this Github repository, which is linked here: https://github.com/UTSA-CS-3443/DND . 

## License

MIT License

Copyright (c) [2023] [Lillian Ngohuynh] [Minato Allen] [Mackenzie Tully] [Alfonso Lopez Aquino]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INC
