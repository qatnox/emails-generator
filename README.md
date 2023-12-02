
**Description:**

The "Corporate Emails Generator" is a Java application designed to simplify the creation of corporate email accounts. This efficient tool processes data from a .csv file, combining surnames and first names to generate a list of email addresses and passwords. The output is then written to another .csv file.

**Key Features:**

  - _CSV Data Processing:_ The program processes input data from a .csv file, utilizing the format "Surname;Name" to extract data for email generation.

  - _Email & Password Generation:_ Using of a database of approximately 100,000 surnames and first names, the application rapidly transliterates and generates unique email addresses and passwords.

  - _Output:_ The generated list, including user IDs, emails, and passwords, is formatted and saved to another .csv file.

  - _Performance Excellence:_ With an impressive processing speed of approximately 0.4 seconds on average, the "Corporate Emails Generator" stands out as a swift and efficient solution for email list creation.

**Usage example:**

    Enter domain: example.com
     1/3 Opening & reading input.csv file...
     2/3 Creating emails & password...
     3/3 Saving to output.csv...
    ============================================
    Saved in corp-emails.csv
    Done in 0.492 sec

**Technical Details:**

    Programming Language: Java
    Transliteration: UA->EN (can be changed)
    Processing Speed: ~0.4 seconds per 100,000 records
    Input Format: input.csv ("Surname;Name")
    Output Format: output.csv ("ID;Email;Password")
