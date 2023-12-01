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

Please ensure you have Android Studio downloaded onto your local computer, and that you have internet access to download the necessary code.
To gain access to the code, all one needs to do is visit this link provided here: https://github.com/UTSA-CS-3443/DND . Then, you can click the green "<>code"<img width="98" alt="Screen Shot 2023-11-30 at 8 40 54 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/d7f54589-e291-4c9d-afa7-2bb5a3f75c6d">
 button and click "Download ZIP" to begin the download of the application onto your local computer. Then you can open the application on Android Studio, and click the Device Manager button on the top right.<img width="31" alt="Screen Shot 2023-11-30 at 8 37 24 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/006dab1a-df16-406b-9870-f2bea440ad06">

 Click the large "Create Device" button,<img width="391" alt="Screen Shot 2023-11-30 at 11 10 42 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/2d299c7c-9da4-44a0-8688-aecfb630a9ee">
 and choose a device to have the application on. For the system image, you must pick the Oreo release name, with an API level of 26. This ensures the application will work on the device. Click "Next", and then click "Finish". This will create an Android Virtual Device, and then you are able to run the application on this AVD. On the top right, to the left of the Device Manager button, is the "sync Project with Gradle Files" button.<img width="33" alt="Screen Shot 2023-11-30 at 8 37 29 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/6fd0167f-9cce-4dd7-bb80-2729ac4135c1">
 Please click the button and allow the IDE a few minutes to sync the project. Once the sync is complete, can you run the application! Click the green arrow in the middle to run the application.<img width="28" alt="Screen Shot 2023-11-30 at 8 42 21 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/c7238153-e0a2-4711-b9f2-657335a5cc82">
 All the required data and documentation are already within the project, therefore no other downloads are required to begin this application. And there you have it! A working character generator with backgrounds, jobs, races, different-sided die, level and advantage drop-downs, notes, and proficiency toggles. 

## Instruction

When the application loads you are set on the welcome screen. From here, you may choose what you want to do with the application. From generating a random character, to picking the proficiency and advantage levels that you may possess. To go back from a view back to the main page, you can just click the back button on the Android Virtual Device.

#### Click "Generate Name" to reach the Name View
#### Click "Dice Roll" to reach the Dice View
#### Click "Notes" to reach the Notes View
#### Click "Credits" to reach the Credit View
#### Click "Exit" to exit the application


### Name View
<img width="203" alt="Screen Shot 2023-11-30 at 8 43 40 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/f1de4304-5b80-43dc-ae52-8d5d18753633">

#### Click "Generate Name" to reach the Name View

1. **Click "Generate Job!"**
   - Will generate a random job in the TextView.

2. **Click "Generate Background!"**
   -Will generate a random background in the TextView.

3. **Select Race**
   - Tap the spinner to display a dropdown menu.
   - Choose which race you want for your character (e.g., Elf, Goliath, Human).

4. **Click "Generate Character Name!"**
   -Will generate a random first and last name in the TextView, and populate the selected race of the character.
   

### Dice View ![image](https://github.com/Lillies-are-Lili/finalproject/assets/102399575/2046277e-cbef-4efa-b6ca-50d118d12e04)

1. **Select Dice Type:**
   - Find the "Dice Type" spinner at the top of the screen.
   - Tap the spinner to display a dropdown menu.
   - Choose the type of dice you want to roll (e.g., D4, D6, D20).
 
2. **Set Proficiency (Optional):**
   - Locate the "Proficiency Level" spinner.
   - Tap to choose your proficiency level, if applicable to your roll.
 
3. **Toggle Proficiency (Optional):**
   - Next to the "Proficiency Level" spinner, you will find a "Proficiency" toggle button.
   - Toggle this on if you want to apply your proficiency level to the roll.
 
4. **Choose Roll Condition:**
   - Find the "Advantage" spinner.
   - Select either "Normal", "Advantage", or "Disadvantage" for your roll.
 
5. **Enter a Custom Modifier (Optional):**
   - Locate the "Custom Modifier" input box.
   - Enter any numerical value to be added or subtracted from your roll.
 
6. **Roll the Dice:**
   - Tap the "Roll" button to perform the dice roll.
   - The result will be displayed immediately on the screen under the "Result" section.
  
 #### Viewing Roll History
- Each roll you make is automatically added to the history table.
- Scroll down to view the last 12 rolls you have made.
- The roll history is displayed in a table format for easy reference.
 
#### Notes
- Ensure your selections are complete before hitting the "Roll" button to get accurate results.
- The history table only maintains the last 12 rolls. Older rolls will be removed as new ones are added.


### Notes View
<img width="207" alt="Screen Shot 2023-11-30 at 11 12 49 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/d88609a7-f8c8-403c-b9cf-891abe044139">

1. **Click EditText Title**
   - Tap the EditText to add a title for your note.
  
2. **Click EditText Body**
   - Tap the EditText to add the body of the note.

3. **Select spinner**
   - Tap the spinner to display a dropdown menu.
   - Choose which note you want to smite or pull.

4. **Click "SMITE"**
   - Will Delete the selected note.

5. **Click "Push"**
   - Will save the note.
   - Will delete current text in preparation for new note creation.

6. **Click "Pull"**
    - Will pull the selected note and print the contents to the screen.
    - Allows editing of notes. 

### Credit View
<img width="228" alt="Screen Shot 2023-11-30 at 11 43 25 PM" src="https://github.com/Lillies-are-Lili/finalproject/assets/102399575/77206156-bb01-471e-8911-3c584640f668">
1. View the contributors to the application.


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


* This method goes through each of the buttons on the Notes view. If the user clicks pull, and pull is empty, it returns a toast that there are no files saved. If there are files that are saved, then to return the contents of the note. If the user clicks push, then the method will save the title and body of the note into an ArrayAdapter object. If the user clicks SMITE, then the method will delete the specified note. 

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

Main Contributors: 
* Lillian Ngohuynh
* Mackenzie Tully
* Alfonso Lopez Aquino
* Minato Allen

The DND Name Generator will be open for improvement after Dec 1st, 2023. Started off as a group project among four aspiring software developers from UTSA, this application will soon have the availability to be an open source project among anyone who wishes to work on it. 
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
