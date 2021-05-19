[![build status](https://github.com/simonpoole/ConditionalRestrictionParser/actions/workflows/javalib.yml/badge.svg)](https://github.com/simonpoole/ConditionalRestrictionParser/actions) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=ConditionalRestrictionParser&metric=alert_status)](https://sonarcloud.io/dashboard?id=ConditionalRestrictionParser) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=ConditionalRestrictionParser&metric=coverage)](https://sonarcloud.io/dashboard?id=ConditionalRestrictionParser) [![sonarcloud bugs](https://sonarcloud.io/api/project_badges/measure?project=ConditionalRestrictionParser&metric=bugs)](https://sonarcloud.io/component_measures?id=ConditionalRestrictionParser&metric=bugs) [![sonarcould maintainability](https://sonarcloud.io/api/project_badges/measure?project=ConditionalRestrictionParser&metric=sqale_rating)](https://sonarcloud.io/component_measures?id=ConditionalRestrictionParser&metric=Maintainability) [![sonarcloud security](https://sonarcloud.io/api/project_badges/measure?project=ConditionalRestrictionParser&metric=security_rating)](https://sonarcloud.io/component_measures?id=ConditionalRestrictionParser&metric=Security) [![sonarcloud reliability](https://sonarcloud.io/api/project_badges/measure?project=ConditionalRestrictionParser&metric=reliability_rating)](https://sonarcloud.io/component_measures?id=ConditionalRestrictionParser&metric=Reliability)
# ConditionalRestrictionParser

This is a very simplistic parser for string values according to the OSM conditional restriction "specification" see http://wiki.openstreetmap.org/wiki/Conditional_restrictions

As there is no grammar provided and a lot of the specification is extremely hand wavy, this is simply a best guess. If a condition can be parsed as a string according to the opening hours specification the corresponding flag in the Condition object will be set, if it is a numeric comparison expression both terms and the operation will be returned.

Running a valid (not so clear what that is, see above) conditional restriction through the parser and producing a string from the results will result in some normalization:
 
* nested parentheses are removed and expanded to encompasses all conditions in one restriction
* "and" is capitalized

## Usage

    try
	 {
	     	ConditionalRestrictionParser parser = new ConditionalRestrictionParser(new ByteArrayInputStream(line.getBytes()));
			List<Restriction> list = parser.restrictions();
		  ...	
	 } catch ...

## Including in your project

You can either download the jar from github or add the following to your build.gradle

	...
	    repositories {
	        ...   
	        mavenCentral() 
	        ...              
	    }
	...
	
	dependencies {
	    ...
	    compile 'ch.poole:ConditionalRestrictionParser:0.3.1'
	    ...
	}
