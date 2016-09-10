# ConditionalRestrictionParser

This is a very simplistic parser for string values according to the OSM conditional restriction "specification" see http://wiki.openstreetmap.org/wiki/Conditional_restrictions

As there is no grammar provided and a lot of the specification is extremely handwavy, this is simply a best guess. If the conditions can be parsed as a string according to the opening hours specification the corresponding flag in the Condition object will be set, if it is a numeric comparison expression bothe terms and the operation will be returned. 

