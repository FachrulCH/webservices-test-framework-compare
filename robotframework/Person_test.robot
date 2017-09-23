*** Settings ***
Library	  Collections
Library	  RequestsLibrary
Library   robot-framework-library/library/JsonValidator.py
Library	  OperatingSystem


*** Test Cases ***
Get profile Luke Skywalker
    Create Session    SWapi    https://swapi.co/api/people/1      verify=True
    ${resp}=    Get Request    SWapi    /
    # Log    ${resp}
    ${response}=    Set Variable       ${resp.json()}
    Should Be Equal As Strings	       ${resp.status_code}	  200
    Dictionary Should Contain Value	   ${response}	        19BBY
    ${name}=    Get From Dictionary    ${response}          name
    Should Be Equal As Strings         ${name}              Luke Skywalker
    # Validate Jsonschema From File      ${response}     ${CURDIR}${/}people-schema.json
    ${schema}=	 OperatingSystem.Get File	   ${CURDIR}${/}people-schema.json
    Log    ${response}
    Log    ${schema}
    Validate jsonschema	              ${response}	    ${schema}
