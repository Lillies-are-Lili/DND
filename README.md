# finalproject

## Synopsis

Embark on a journey into a world of endless possibilities with DND Name Generator, the ultimate Dungeons & Dragons character generation! Unleash your creativity and bring your characters to life with a tool that goes beyond mundane names. Elevate your gaming experience with our unique dice roll feature, allowing you to pick a specific number-sided die and even add proficiency, advantage or disadvantage, for an extra layer of spontaneity. Dive into a rich tapestry of fantasy realms as you effortlessly generate unique and immersive names for races, backgrounds, creatures, and more. One can also notate and keep all of their characters that they generate. Reveal the power of words and forge a connection between your players and the fantastical realms they inhabit. DND Name Generator is not just a name generator; it's a key to unlocking the immersive potential of your Dungeons & Dragons adventures. Elevate your storytelling and embark on a quest of boundless creativity today!

## Code Example

For example, we have added CSV files detailing the various characteristics to our assets folder, and have methods that read in the files and randomly generate a characteristic for your character.

   /**
     * This method generates a background for your character
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
To gain access to the code, all one needs to do is visit this link provided here: https://github.com/UTSA-CS-3443/DND . Then, you can click the green "<>code" button and click "Download ZIP" to begin the download of the application onto your local computer. Then you can open the application on Android Studio, and click the Device Manager button on the top right. Click the large "Create Device" button, and choose a device to have the application on. For the system image, you must pick the Oreo release name, with an API level of 26. This ensures the application will work on the device. Click "Next", and then click "Finish". This will create an Android Virtual Device, and then you are able to run the application on this AVD. On the top right, to the left of the Device Manager button, is the "sync Project with Gradle Files" button. Please click the button and allow the IDE a few minutes to sync the project. Once the sync is complete, can you run the application! Click the green arrow in the middle to run the application. All the required data and documentation are already within the project, therefore no other downloads are required to begin this application. And there you have it! A working character generator with backgrounds, jobs, races, different-sided die, level and advantage drop-downs, notes, and proficiency toggles.


## API Reference

Depending on the size of the project, if it is small and simple enough the reference docs can be added to the README. For medium size to larger projects it is important to at least provide a link to where the API reference docs live.

## Tests

   
     * This method takes in the two randomly selected last name, and first name, and concatenates them togeter.
     * While in the Name view, there is a spinner that allows the user to pick the race they desire. Whatever race they pick, will populate with the name generated. 
     
     
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

 
     * Similar to the method in the Code Example at the top of the README, this method scans in the jobs from the provided CSV files, and randomly picks one to be printed to the 
     * screen when the user clicks the appropriate button in the Name view. 
     
     
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

     /**
       * This method returns the text that the user saved in the Notes view. 
       */

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

          /** 
            * This method finds a file and if the file exists, updates the file to what the user wants, but if it doesn't exist, then creates the file. 
            */
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

 /**
   * This method first checks if a dice was selected, and then if a proficiency toggle was checked. If both were, if the advantage spinner was set to advantage, if roll1 was         *bigger than roll2, display roll1. If disadvantage was chosen, then if roll1 is bigger then roll2, display roll2.
   * 
   */

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


 /**
   * This method returns whichever sided die the user picked
   * /

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


    public void onClick(View view) {
        if (view.getId() == R.id.Pull) {
            // Handle Pull button click
            if (noteNames.isEmpty()) {
                Toast.makeText(this, "YOU HAVE NO MORE FILES TO PULL", Toast.LENGTH_SHORT).show();
            } else {
                // Set text fields with selected note content
                tile.setText(spinner.getSelectedItem().toString());
                body.setText(notes.getText(noteNames.indexOf(spinner.getSelectedItem().toString())));
//                Toast.makeText(this, "Hurrah", Toast.LENGTH_SHORT).show();
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

We will have all of our updates for the project on this Github repository, which is linked here: https://github.com/UTSA-CS-3443/DND . 

## License

A short snippet describing the license (MIT, Apache, etc.)
