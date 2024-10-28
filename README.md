## Electronic Devices

**Overview** 

The Device Manager is a JavaFX application that allows users to manage electronic devices, including smartphones, laptops, and tablets. Users can add and remove devices from a list and input relevant information for each device type.


**Features**

***Device Types:*** Support for three types of devices: Smartphone, Laptop, and Tablet.

***User Interface:*** A user-friendly GUI with tabs for each device type and a list view to display added devices.

***Data Validation:*** Input validation to ensure that all required fields are filled correctly.

***Alert System:*** Error alerts for invalid inputs or selection issues.

**Technologies Used**

Java 17 or higher
JavaFX
FXML
Maven (for dependency management)

**Usage**

***Select a Device Type:*** Navigate through the tabs for different device types (Smartphone, Laptop, Tablet).

***Input Device Information:*** Fill in the required fields for the selected device type.

***Add Device:*** Click the "Add" button to add the device to the list.

***Remove Device:*** Select a device from the list and click the "Remove" button to delete it.

**Code Structure**

***HelloApplication.java:*** The main application class that launches the JavaFX application.

***HelloController.java:*** The controller class that handles the logic for the GUI.

***Device.java:*** The base class representing a generic device.

***Smartphone.java, Laptop.java, Tablet.java:*** Classes representing specific types of devices, inheriting from the Device class.

***DeviceType.java:*** An enum defining the types of devices.

## Screenshots

***Smartphone***

<img width="1278" alt="Снимок экрана 2024-10-28 в 15 52 35" src="https://github.com/user-attachments/assets/55cf89bd-6a7d-4eee-80bd-c25417032907">



***Laptop***


<img width="1268" alt="Снимок экрана 2024-10-28 в 15 53 59" src="https://github.com/user-attachments/assets/8264a362-b4c7-4458-90dd-cb6e9c366cbd">


***Tablet***


<img width="1275" alt="Снимок экрана 2024-10-28 в 15 54 57" src="https://github.com/user-attachments/assets/c1fe7847-733f-4b78-b88f-ac81d32636f6">



***Output***

<img width="1265" alt="Снимок экрана 2024-10-28 в 15 56 50" src="https://github.com/user-attachments/assets/ee97986c-4940-416b-abfe-8dfcca4a30d0">
