# PurgoMalum-Test

## Overview
PurgoMalum is a simple, free, RESTful web service for filtering and removing content of profanity, obscenity and other unwanted text. PurgoMalum's interface accepts several parameters for customization and can return results in plain text, XML and JSON.

PurgoMalum is designed to remove words from input text, based on an internal profanity list (you may optionally add your own words to the profanity list through a request parameter (see Request Parameters below). It is designed to recognize character alternates often used in place of standard alphabetic characters, e.g. "@" will be recognized as an "a", "$" will be recognized as an "s", and so forth.

PurgoMalum also utilizes a list of "safe words", i.e. innocuous words which contain words from the profanity list ("class" for example). These safe words are excluded from the filter.

## High Level Architecture


## Testing Approach
- Test Cases are organized based on Positive Scenarios, Negative Scenarios and Non-Functional categories
- We have used BDD(Behavior Driven Development) approach to design the test cases.
- Objective is to utilize the same test case template for automation which enforces externalized parameterization via test-cases to avoid coupling in the code.
- Test Cases are executed using Postman

## Test-Cases

## Test Case Execution 

## Observations/Defects




