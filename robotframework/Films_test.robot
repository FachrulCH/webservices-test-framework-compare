*** Settings ***
Library	  Collections
Library	  RequestsLibrary


*** Test Cases ***
Get list of Star Wars Films
    Create Session    SWapi    https://swapi.co/api/films      verify=True
    ${resp}=    Get Request    SWapi    /
    # Log    ${resp}
    ${response}=    Set Variable       ${resp.json()}
    Should Be Equal As Strings	       ${resp.status_code}	  200
    Log    ${response}
    # Dictionary Should Contain Key      ${response}            opening_crawl
    Dictionary Should Contain Key      ${response}            results
    # TODO get title nya ${title}=    Get From Dictionary    ${response}          results[0].title
    # Should Be Equal As Strings         ${title}              A New Hope
    # TODO Validate Jsonschema From File      ${response}     ${CURDIR}${/}people-schema.json
