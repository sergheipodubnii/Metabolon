Feature: Open MRS tests

  @openMRS
  Scenario: Register a patient
    Given the user logs in to OpenMRS with following credentials
      | username | admin    |
      | password | Admin123 |
    When the user registers a new patient with following information:
      | GivenName    | mehmet           |
      | FamilyName   | doganer          |
      | Gender       | Male             |
      | Day          | 13               |
      | Month        | August           |
      | Year         | 1992             |
      | Address      | 2200 E Devon ave |
      | PhoneNumber  | 3147148390       |
      | RelationType | Doctor           |
      | RelativeName | Potel            |
    Then the user validates the patient name and familyName
      | GivenName  | mehmet  |
      | FamilyName | doganer |


