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
To gain access to the code, all one needs to do is visit this link provided here: https://github.com/UTSA-CS-3443/DND. Then, you can click the green "<>code" button and click "Download ZIP" to begin the download of the application onto your local computer. Then you can open the application on Android Studio, and click the Device Manager button on the top right. Click the large "Create Device" button, and choose a device to have the application on. For the system image, you must pick the Oreo release name, with an API level of 26. This ensures the application will work on the device. Click "Next", and then click "Finish". This will create an Android Virtual Device, and then you are able to run the application on this AVD. On the top right, to the left of the Device Manager button, is the "sync Project with Gradle Files" button. Please click the button and allow the IDE a few minutes to sync the project. Once the sync is complete, can you run the application! Click the green arrow in the middle to run the application. All the required data and documentation are already within the project, therefore no other downloads are required to begin this application. And there you have it! A working character generator with backgrounds, jobs, races, different-sided die, level and advantage drop-downs, notes, and proficiency toggles.


## API Reference

Depending on the size of the project, if it is small and simple enough the reference docs can be added to the README. For medium size to larger projects it is important to at least provide a link to where the API reference docs live.

## Tests

Describe and show how to run the tests with code examples.

   /**
     * This method takes in the two randomly selected last name, and first name, and concatenates them togeter.
     * While in the Name view, there is a spinner that allows the user to pick the race they desire. Whatever race they pick, will populate with the name generated. 
     */
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

 /**
     * Similar to the method in the Code Example at the top of the README, this method scans in the jobs from the provided CSV files, and randomly picks one to be printed to the 
     * screen when the user clicks the appropriate button in the Name view. 
     */
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

## Contributors

Let people know how they can dive into the project, include important links to things like issue trackers, irc, twitter accounts if applicable.

## License

A short snippet describing the license (MIT, Apache, etc.)
