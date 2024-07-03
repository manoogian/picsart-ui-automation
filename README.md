
---

# Picsart Web Automation Framework (Java)

This repository contains a web automation framework using Java, Selenium WebDriver, TestNG, and Maven for testing Picsart Search functionality across different resolutions.

## Setup Instructions

1. **Prerequisites:**
    - Java JDK installed on your system.
    - Maven installed on your system.
    - Chrome browser installed.

2. **Clone the repository:**
```code
git clone https://github.com/manoogian/picsart-ui-automation.git
```


## Running Tests

To run the tests on different resolutions in parallel using TestNG:

```code
USE src/test/resources/Parallel_Dimensions_Execution.xml file
```

## Test Case

### Test Scenario

1. Navigate to Picsart Search.
2. Click on the filter button and verify that the filters disappear.
3. Click on the filter button again to open the filters.
4. Choose the "Personal" checkbox from the “License” section and verify that there are no “PLUS” assets. Hovering over an asset should display the like, save, and try now buttons.
5. Click on the like button and verify that the sign-in popup appears.
6. Close the popup.
7. Remove the filter.
8. Hover over a “PLUS” asset and verify that only the “try now” button appears.
9. Click on the “try now” button and verify that the editing screen opens with the image applied to the canvas.

### Test Execution

- The tests will be executed on Chrome browser.
- Tests will run in parallel on the specified resolutions.
- Assertions and verifications will ensure expected behaviors and elements are present as per the test steps.

## Project Structure

```
picsart-web-automation-java/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── picsart/
│   │   │           └── automation/
│   │   │               └── ui/
│   │   │                   ├── pages/                      # Page classes
│   │   │                   ├── popups/                     # Popup classes
│   │   │                   ├── sections/                   # Section classes
│   │   │                   └── BaseComponent.java          # Base Component for different sections, popups etc...
│   │   └── resources/
│   │
│   │
│   └── test/
│   │   │   └── com/
│   │   │       └── picsart/
│   │   │           └── automation/
│   │   │               └── ui/
│   │   │                   |── regression/   
│   │   │                       |── BaseTest.java/          # Base Test where implemented methods like general preconditions for the tests
│   │   │                       └── IntegrationTest.java/   # Task Scenario implementation
│   │   │                   └── smoke/                       
│       └── resources/
│           └── Parallel_Dimensions_Execution.xml           # TestNG XML file to run parallel
│         
│
├── pom.xml                                                 # Maven dependencies and configuration
└── README.md                                               # This file
```

## Notes

- Modify the test implementation (`src/test/java/com/picsart/automation/v1/regression`) or page objects (`src/main/java/com/picsart/automation/v1`) to extend and enhance test coverage as needed.

---

Feel free to customize this README.md file further to include specific details about your implementation, additional setup steps, or any other relevant information!