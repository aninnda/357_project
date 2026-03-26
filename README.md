# 357_project
# Walkr: Gamified Fitness Tracker

Walkr is a step-tracking mobile application designed to combat sedentary lifestyles by replacing traditional numerical data with metaphor-based visual milestones. Developed for **SOEN 357: User Interaction Design** at Concordia University, this project utilizes social competition and gamification to sustainably increase daily physical activity.

---

## Project Purpose

* **Problem**: High sedentary behavior due to technology-driven routines and a lack of motivation in traditional trackers.
* **Hypothesis**: Metaphor-based milestones (e.g., "Climbing Mount Everest") and real-time peer leaderboards will increase average daily step counts more effectively than standard data visualization.
* **Target Population**: Individuals seeking to be more active through social interaction and friendly competition.

---

## Prerequisites

Before setting up the project, ensure the following are installed:

* **Java Development Kit (JDK) 11**: Required for the Spring Boot backend.
* **Android Studio**: Primary IDE for Android development and Gradle management.
* **Node.js and npm**: Necessary for managing React Native dependencies.
* **Hardware**: An Android or iOS device (or emulator) for testing physical activity tracking.

---

## Step-by-Step Execution

### 1. Clone the Repository
Open your terminal and clone the project from GitHub:

git clone [https://github.com/aninnda/357_project.git](https://github.com/aninnda/357_project.git)

### 2. Backend Configuration (Spring Boot)
1. Navigate to the directory containing the Spring Boot files.
2. Open the project in Android Studio or your preferred Java IDE.
3. Ensure the `pom.xml` dependencies are synced to include all necessary backend libraries.
4. Run the application through the IDE or using the Maven wrapper:
   ./mvnw spring-boot:run
   
### 3. Frontend Configuration (React Native)
Navigate to the frontend project folder and install the required TypeScript and React Native packages: npm install

Start the Metro Bundler: npm start

### 4. Running the Android Application
1. In Android Studio, go to File > Open and select the android folder within the frontend directory.
2. Wait for the Gradle Sync to finish successfully to ensure all UI components and Material Design libraries are linked.
3. Select your target device (Emulator or physical phone).
4. Click the Run (Green Play) button.

### 5. UI preview:

<img width="295" height="637" alt="Screenshot 2026-03-26 at 12 23 02 AM" src="https://github.com/user-attachments/assets/f488a5a8-b90e-488a-86b3-6f660b02f4f2" />

<img width="297" height="615" alt="Screenshot 2026-03-26 at 12 23 17 AM" src="https://github.com/user-attachments/assets/1c83203a-d59e-440a-8f8a-2ad758a84f11" />

<img width="294" height="623" alt="Screenshot 2026-03-26 at 12 23 40 AM" src="https://github.com/user-attachments/assets/4528f718-eb7e-4a2b-bc34-1f74487d7bee" />

<img width="295" height="620" alt="Screenshot 2026-03-26 at 12 23 52 AM" src="https://github.com/user-attachments/assets/5b524908-c970-4bab-ab2f-695b432daccc" />



