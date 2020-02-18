#### Simple Country Report

| **Name** | Simple country report |
| --- | --- |
| **Description** | An employee of the organisation generates a report related to all the countries in a specified geographical unit, ordered from largest to smallest |
| **Actors** | Employee |
| **Benefits to Organization** | The business will be able to generate reports on population data, enabling its broader function as an organisation |
| **Trigger(s)** | The employee is met with a request for a simple country report |
| **Preconditions** | Employee is logged on to the system and has the correct authorisation for the querying application |
| **Postconditions** | A report is generated, listing the countries in a certain geographical unit from largest to smallest |
| **Main Course** | **1A.** Employee constructs SQL query for all the countries in the world 
|       				  | **2.** Employee submits query (See EX1)
|       				  | **3.** Database returns a table of results (See EX2) |
| **Alternate Courses** | **1B.** Employee constructs SQL query for all the countries in a specified continent
|       				  | **1C.** Employee constructs SQL query for all the countries in a specified region |
| **Exceptions** | EX1: the employee-supplied SQL query contains invalid syntax
|				         | EX2: the database fails to return any rows |

#### Specified Country Reports

| **Name** | Specified Country Report |
| --- | --- |
| **Description** | An employee of the organisation generates a report related to a specified number of countries  (N) in a specified geographical unit |
| **Actors** | Employee |
| **Benefits to Organization** | The business will be able to generate reports on population data, enabling its broader function as an organisation |
| **Trigger(s)** | The employee is met with a request for a specified country report |
| **Preconditions** | Employee is logged on to the system and has the correct authorisation for the querying application |
| **Postconditions** | A report is generated, listing _N_ countries in a specified geographical unit from largest to smallest |
| **Main Course** | **1A.** Employee constructs SQL query for _N_ number of countries in the world
|       				  | **2.** Employee submits query (See EX1)
|       				  | **3.** Database returns a table of results (See EX2) |
| **Alternate Courses** | **1B.** Employee constructs SQL query for _N_ number of countries in a specified continent
|       				  | **1C.** Employee constructs SQL query for _N_ number of countries in a specified region |
| **Exceptions** | EX1: the employee-supplied SQL query contains invalid syntax
|				         | EX2: the database fails to return any rows |

#### Simple City Report

| **Name** | Simple City Report |
| --- | --- |
| **Description** | An employee of the organisation generates a report related to all the cities in a specified geographical unit |
| **Actors** | Employee |
| **Benefits to Organization** | The business will be able to generate reports on population data, enabling its broader function as an organisation |
| **Trigger(s)** | The employee is met with a request for a simple city report |
| **Preconditions** | Employee is logged on to the system and has the correct authorisation for the querying application |
| **Postconditions** | A report is generated, listing all the cities in a certain geographical unit from largest to smallest |
| **Main Course** | **1A.** Employee constructs SQL query for all cities  in the world
|       				  | **2.** Employee submits query (See EX1)
|       				  | **3.** Database returns a table of results (See EX2) |
| **Alternate Courses** | **1B.** Employee constructs SQL query for all cities in a specified continent
|       				  | **1C.** Employee constructs SQL query for all cities in a specified region 
|       				  | **1D.** Employee constructs SQL query for all cities in a specified country 
|       				  | **1E.** Employee constructs SQL query for all cities in a specified district |
| **Exceptions** | EX1: the employee-supplied SQL query contains invalid syntax
|       				 | EX2: the database fails to return any rows |

#### Specified City Reports

| **Name** | Specified City Report |
| --- | --- |
| **Description** | An employee of the organisation generates a report related to a specified number of cities (N) within specified geographical unit |
| **Actors** | Employee |
| **Benefits to Organization** | The business will be able to generate reports on population data, enabling its broader function as an organisation |
| **Trigger(s)** | The employee is met with a request for a specified city report |
| **Preconditions** | Employee is logged on to the system and has the correct authorisation for the querying application |
| **Postconditions** | A report is generated, listing _N_ cities in a specified geographical unit from largest to smallest |
| **Main Course** | **1A.** Employee constructs SQL query for _N_ most populated cities  in the world
|       				  | **2.** Employee submits query (See EX1)
|       				  | **3.** Database returns a table of results (See EX2) |
| **Alternate Courses** | **1B**. Employee constructs SQL query for _N_ most populated cities in a specified continent
|       				  | **1C.** Employee constructs SQL query for _N_ most populated cities in a specified region
|       				  | **1D.** Employee constructs SQL query for _N_ most populated cities in a specified country 
|       				  | **1E.** Employee constructs SQL query for _N_ most populated cities in a specified district |
| **Exceptions** | EX1: the employee-supplied SQL query contains invalid syntax
|				         | EX2: the database fails to return any rows |

#### Simple Capital City Reports

| **Name** | Simple Capital City Report |
| --- | --- |
| **Description** | An employee of the organisation generates a report related to all the capital cities in a specified geographical unit |
| **Actors** | Employee |
| **Benefits to Organization** | The business will be able to generate reports on population data, enabling its broader function as an organisation |
| **Trigger(s)** | The employee is met with a request for a capital city report |
| **Preconditions** | Employee is logged on to the system and has the correct authorisation for the querying application |
| **Postconditions** | A report is generated, listing all the capital cities in the world, ordered from largest to smallest |
| **Main Course** | **1A.** Employee constructs SQL query for all the capital cities in the world
|       				  | **2.** Employee submits query (See EX1)
|       				  | **3.** Database returns a table of results (See EX2) |
| **Alternate Courses** | **1B.** Employee constructs SQL query for all the capital cities in a specified continent
|       				  | **1C.** Employee constructs SQL query for all the capital cities in a specified region |
| **Exceptions** | EX1: the employee-supplied SQL query contains invalid syntax
|				         | EX2: the database fails to return any rows |

#### Specified Capital City Reports

| **Name** | Specified Capital City Report |
| --- | --- |
| **Description** | An employee of the organisation generates a report showing a specified number (N) of the most-populated capital cities in a specified geographical unit |
| **Actors** | Employee |
| **Benefits to Organization** | The business will be able to generate reports on population data, enabling its broader function as an organisation |
| **Trigger(s)** | The employee is met with a request for a specified capital city report |
| **Preconditions** | Employee is logged on to the system and has the correct authorisation for the querying application |
| **Postconditions** | A report is generated, listing _N_ capital cities in a given geographical unit, ordered from largest to smallest |
| **Main Course** | **1A.** Employee constructs SQL query for the _N_ most populated capital cities in the world
|       				  | **2.** Employee submits query (See EX1)
|       				  | **3.** Database returns a table of results (See EX2) |
| **Alternate Courses** | **1B.** Employee constructs SQL query for the _N_ most populated capital cities in a specified continent
|       				  | **1C.** Employee constructs SQL query for the _N_ most populated capital cities in a specified region |
| **Exceptions** | EX1: the employee-supplied SQL query contains invalid syntax
|				         | EX2: the database fails to return any rows |

#### Urban-Rural Report

| **Name** | Urban-Rural Report |
| --- | --- |
| **Description** | An employee of the organisation generates a report related to the amount of people living within and without cities in a set of specified geographical units |
| **Actors** | Employee |
| **Benefits to Organization** | The business will be able to generate reports on population data, enabling its broader function as an organisation |
| **Trigger(s)** | The employee is met with a request for an urban-rural report |
| **Preconditions** | Employee is logged on to the system and has the correct authorisation for the querying application |
| **Postconditions** | A report is generated, showing the total population of people living in and outside of cities within the set of specified geographical units |
| **Main Course** | **1A.** Employee constructs SQL query for the number of people living in and outside of cities in each continent |
|       				  | **2.** Employee submits query (See EX1)
|       				  | **3.** Database returns table of results (See EX2)
| **Alternate Courses** | **1B.** Employee constructs SQL query for the number of people living in and outside of cities in each region
|       				  | **1C.** Employee constructs SQL query for the number of people living in and outside of cities in each country |
| **Exceptions** | EX1: the employee-supplied SQL query contains invalid syntax
|				         | EX2: the database fails to return any rows |

#### Global Language Report

| **Name** | Global language report |
| --- | --- |
| **Description** | An employee of the organisation generates a report displaying the number of speakers of Chinese, English, Hindi, Spanish and Arabic, along with each language&#39;s users as a percentage of the world population |
| **Actors** | Employee |
| **Benefits to Organization** | The business will be able to generate reports on population data, enabling its broader function as an organisation |
| **Trigger(s)** | The employee is met with a request for a global language report |
| **Preconditions** | Employee is logged on to the system and has the correct authorisation for the querying application |
| **Postconditions** | A report is generated, listing the countries in a certain geographical unit from largest to smallest |
| **Main Course** | **1A.** Employee constructs SQL query for the number of speakers of Chinese, English, Hindi, Spanish and Arabic, with the number of users as a percentage of global population
|       				  | **2.** Employee submits query (See EX1)
|       				  | **3.** Database returns a table of results (See EX2) |
| **Alternate Courses** | There are no alternate courses. |
| **Exceptions** | EX1: the employee-supplied SQL query contains invalid syntax
|				         | EX2: the database fails to return any rows |
