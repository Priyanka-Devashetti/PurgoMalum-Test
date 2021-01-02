# PurgoMalum-Test

## Overview
PurgoMalum is a simple, free, RESTful web service for filtering and removing content of profanity, obscenity and other unwanted text. PurgoMalum's interface accepts several parameters for customization and can return results in plain text, XML and JSON.

PurgoMalum is designed to remove words from input text, based on an internal profanity list (you may optionally add your own words to the profanity list through a request parameter (see Request Parameters below). It is designed to recognize character alternates often used in place of standard alphabetic characters, e.g. "@" will be recognized as an "a", "$" will be recognized as an "s", and so forth.

PurgoMalum also utilizes a list of "safe words", i.e. innocuous words which contain words from the profanity list ("class" for example). These safe words are excluded from the filter.

## High Level Architecture
<img width="721" alt="Screenshot 2020-12-28 at 6 55 23 PM" src="https://user-images.githubusercontent.com/58664897/103237072-7aaead00-493e-11eb-8b92-016c37b642d3.png">


## Testing Approach
- Test Cases are organized into  Positive, Negative and Non-Functional categories
- We have used BDD(Behavior Driven Development) approach to design the test cases.
- Objective is to utilize the same test case template for automation. 
- Placeholder is provided in the test cases to externalize the input parameters which enforces parameter externalization and avoids code coupling.
- Test Cases are executed using Postman

## Test-Cases
### Positive Scenarios

<table class="tg">
<thead>
  <tr>
    <th class="tg-q5wn">Test case&nbsp;&nbsp;&nbsp;ID</th>
    <th class="tg-q5wn">Description</th>
    <th class="tg-q5wn">HTTP Method</th>
    <th class="tg-q5wn">Response Format</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td >TC001</td>
    <td >Scenario&nbsp;&nbsp;&nbsp;Outline:Perform the API output format validation <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Given: API end pointmust be accessible <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;When API end point is hit by providing "&lt;Input_Text&gt;" along&nbsp;&nbsp;&nbsp;with expected "&lt;Output_Format&gt;"  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Then we must get successful response &nbsp;&nbsp;&nbsp;in the expected &nbsp;&nbsp;&nbsp;&lt;Output_Format&gt;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Examples|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Output_Format|Input_Text|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|XML|"this is some text"| &nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|JSON|"this is some text"|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Pain-text|"this is some text"|</td>
    <td >GET</td>
    <td >XML,JSON,Plain-text</td>
  </tr>
  <tr>
    <td >TC002</td>
    <td >Scenario&nbsp;&nbsp;&nbsp;Outline: Verify containsProfanity &nbsp;&nbsp;&nbsp;functionlity when profanity words exits in the Input<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Given :API end point must be accessible andprofanity list must be&nbsp;&nbsp;&nbsp;updated<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;When : &lt;Input_Text&gt;  which&nbsp;&nbsp;&nbsp;contains words from profanity list is provided in the API Request <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Then API Response should be successfull with boolean output as true<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Examples|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Input_Text|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|This is a bullshit  place|</td>
    <td >GET</td>
    <td >Plain-text</td>
  </tr>
  <tr>
    <td >TC003</td>
    <td >Scenario&nbsp;&nbsp;&nbsp;Outline: Verify containsProfanity &nbsp;&nbsp;&nbsp;functionlity when profanity words doesn't exist  in the Input<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Given :API end point must be accessible andprofanity list must be&nbsp;&nbsp;&nbsp;updated<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;When : &lt;Input_Text&gt;  which&nbsp;&nbsp;&nbsp;doesn't contain words from profanity list is provided in the API Request&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Then API Response should be successfull with boolean output as false<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Examples|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Input_Text|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|This is a bullshit  place|</td>
    <td >GET</td>
    <td >Plain-text</td>
  </tr>
  <tr>
    <td >TC004</td>
    <td >Scenario&nbsp;&nbsp;&nbsp;Outline: Verify replaceFunctionlaity for all different format API&nbsp;&nbsp;&nbsp;response<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Give : API end point must be accessible <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;When "&lt;Output_Format&gt;" and &nbsp;&nbsp;&nbsp;replace words passed via API end point with conditional statement and&nbsp;&nbsp;&nbsp;hit the service <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Then API response must be successfull with replaced words and  in different&nbsp;&nbsp;&nbsp;"&lt;Output_Format&gt;"<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Examples|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Output_Format|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|XML|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|JSON|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Pain-text|</td>
    <td >GET</td>
    <td >XML,JSON,Plain-text</td>
  </tr>
  <tr>
    <td >TC005</td>
    <td >"Scenario&nbsp;&nbsp;&nbsp;Outline:Perform Long Input Text Validation for Different Output Formats<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Given: API end pointmust be accessible <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;When API end point is hit by providing &nbsp;&nbsp;&nbsp;long "&lt;Input_Text&gt;" along with expected&nbsp;&nbsp;&nbsp;"&lt;Output_Format&gt;" <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Then Response should be successfull with&nbsp;&nbsp;&nbsp;""&lt;Input_text&gt;"" and in expected&nbsp;&nbsp;&nbsp;&lt;Output_Format&gt;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Examples|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Output_Format|Input_Text|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|XML|"this is some text 123 345 678 897 888 999 990 4444&nbsp;&nbsp;&nbsp;2222"|  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|JSON|"This is some test&nbsp;&nbsp;&nbsp;inputtttttttttttttttttttttinputtttttttttttttttttttttinputtttttttttttttttttttttinputtttttttttttttttttttttinputtttttttttttttttttttttinputttttttttttttttttttttti |<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Pain-text|"this is some tex wet GHJHKJ JUHLK; EWSDRTYUIK HJKL 45678O&nbsp;&nbsp;&nbsp;GHJNKM"|"</td>
    <td >GET</td>
    <td >XML,JSON,Plain-text</td>
  </tr>
  <tr>
    <td >TC006</td>
    <td >"Scenario&nbsp;&nbsp;&nbsp;Outline:Validate the Special Characters in the Input Text<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Given: API end pointmust be accessible <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;When API end point is hit by providing &nbsp;&nbsp;&nbsp;special character in &nbsp;&nbsp;&nbsp;"&lt;Input_Text&gt;" along with expected&nbsp;&nbsp;&nbsp;"&lt;Output_Format&gt;" <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Then Response should be successfull with&nbsp;&nbsp;&nbsp;""&lt;Input_text&gt;"" and in expected&nbsp;&nbsp;&nbsp;&lt;Output_Format&gt;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Examples|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Output_Format|Input_Text|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|XML|"this is some text &nbsp;&nbsp;&nbsp;"Hello"*)&amp;&amp;@%"| &nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|JSON|"this is some text "Hi Roma" #$%^"|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Pain-text|"this is some tex &nbsp;&nbsp;&nbsp;"Sorry" wet ^!@#$"|"</td>
    <td >GET</td>
    <td >XML,JSON,Plain-text</td>
  </tr>
  <tr>
    <td>TC007</td>
    <td >"Scenario&nbsp;&nbsp;&nbsp;Outline:Validate space corrections (leading space, trailing space and interim&nbsp;&nbsp;&nbsp;additional spaces in the sentences) by API<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Given: API end pointmust be accessible <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;When API end point is hit by providing different type of spaces in  "&lt;Input_Text&gt;" along with&nbsp;&nbsp;&nbsp;expected "&lt;Output_Format&gt;" <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Then Response should be successfull with "&lt;Input_text&gt;" and&nbsp;&nbsp;&nbsp;in expected &lt;Output_Format&gt;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Examples|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Output_Format|Input_Text|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|XML|"               This&nbsp;&nbsp;&nbsp;is  Some                  text          " |  <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|JSON|"                   Happy&nbsp;&nbsp;&nbsp;New Year                            "|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Pain-text|"                                    Merry&nbsp;&nbsp;&nbsp;Christmas                          &nbsp;&nbsp;&nbsp;"|"</td>
    <td >GET</td>
    <td >XML,JSON,Plain-text</td>
  </tr>
  <tr>
    <td >TC008</td>
    <td >Scenario&nbsp;&nbsp;&nbsp;Outline:  Verify profanity word&nbsp;&nbsp;&nbsp;addition to the list and API response <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Give : API end point must be accessible <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;When API end point is hit by providing &nbsp;&nbsp;&nbsp;new "&lt;Profin_Word&gt;" &nbsp;&nbsp;&nbsp;and "&lt;Input_Text&gt;" &nbsp;&nbsp;&nbsp;with conditional statement<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Then new "&lt;Profin_Word&gt;" &nbsp;&nbsp;&nbsp;should be added to the list and &nbsp;&nbsp;&nbsp;"&lt;Profin_Word&gt;" &nbsp;&nbsp;&nbsp;should be replaced with configured special character<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Examples|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|Profin_Word|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|vulgar|<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td >GET</td>
    <td >XML,JSON,Plain-text</td>
  </tr>
</tbody>
</table>


### Negative Scenarios
<table>
<thead>
  <tr>
    <th>Test&nbsp;&nbsp;&nbsp;case ID</th>
    <th>Description</th>
    <th>HTTP Method</th>
    <th>Type of&nbsp;&nbsp;&nbsp;Response</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>TC001</td>
    <td>Scenario Outline: Empty Input Text   Valiadtion<br>     Given: API end   point  must be accessible <br>     When API end point is   hit without providing any Input Text along with expected   "&lt;Output_Format&gt;"    <br>     Then user should see   the error message in all expected "&lt;Output_Format&gt;"<br>     |Examples|<br>     |Output_Format|<br>     |XML|<br>     |JSON|<br>     |Pain-text|</td>
    <td>GET</td>
    <td>XML,JSON,Plain-text</td>
  </tr>
  <tr>
    <td>TC002</td>
    <td>Scenario Outline:  Verify Profinity word limit in the   Request<br>     Give : API end point   &lt;api_end_point&gt; must be accessible <br>     When API end point is   hit by providing  more than 10  "&lt;Profin_Word&gt;"  and "&lt;Input_Text&gt;"  along with conditional   statement,"&lt;Output_Format&gt;"<br>     Then user should see   the "&lt;Error_Message&gt;" in all expected   "&lt;Output_Format&gt;"<br>     |Examples|<br>     |Profin_Word|Error_Message|<br>     |vulgar,a,b,c,d,e,f,g,h,i,j,k,l|User Black List Exceeds Limit of 10   Words.<br>     </td>
    <td>GET</td>
    <td>XML,JSON,Plain-text</td>
  </tr>
  <tr>
    <td>TC003</td>
    <td>Scenario Outline:  Validate the response for HTTP method other   than GET<br>     Given : API end point   must be accessible <br>     When API end point is   hit by providing valid ""&lt;Input_Text&gt;""  using   ""&lt;Non_GET_HTTP_Method&gt;""<br>     Then user should able   to get the 405 status with message "Method Not Allowed"<br>     |Examples|<br>     |Input_Text|Non_GET_HTTP_Method|<br>     |This is a sample Test|POST|<br>     |This is a sample Test|PUT|<br>     |This is a sample Test|DELETE|<br>     "</td>
    <td>GET</td>
    <td>XML,JSON,Plain-text</td>
  </tr>
</tbody>
</table>


## Test Case Execution 

## Observations/Defects




