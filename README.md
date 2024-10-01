# college-app-application-java

## Automating the college application process.

A college needs assistance reviewing applications, reviewed applicants will be categorized as follows:

* Instant Accept
* Instant Reject
* Further Review

Criteria around categories:

* Instant Accept

```
- In-state (California) age 17 or older, and younger than 26; or older than 80 from any state.
- High School com.mandon.collegeappapi.criteria.GPA of 90% or higher of scale provided in their application. E.g. 3.6 on a 4.0 scale or 4.5 on a 5.0 scale.
- SAT score greater than 1920 or ACT greater than 27. Note: Both or only one may be present in application.
- No "instant reject" com.mandon.collegeappapi.criteria is hit.
```

* Instant Reject

```
- 1 or more felonies over the past 5 years.
- High School com.mandon.collegeappapi.criteria.GPA below 70% of scale provided on application.
- The applicant claimed to be a negative age. E.g. "-20" years old.
- The applicant first and/or last name are not in the form of first letter capitalized, the rest lower case.

```

* Further Review

```
- Candidate does not qualify for instant accept nor instant reject.
```

College Requirements

```
- Store the candidate information.
- Return results to convey "instant accept", "instant reject", "further review". Return plain text descriptions if an applicant is marked for "instant reject".
- Code should be able to handle potential changes and additions to the rules in the future.
```