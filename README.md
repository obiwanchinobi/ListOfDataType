XML
----

'
Class koo.Book Extends %Persistent
{

Property Tags As %ListOfDataTypes(JAVATYPE = "java.util.List");

ClassMethod CreateBook(tags As %ListOfDataTypes)
{
	set book = ##class(koo.Book).%New()
	set tagCount = tags.Count()
	for i = 1:1:tagCount {
		do book.Tags.Insert(tags.GetAt(i))
	}
	set sc = book.%Save()
}

/// Test the CreateBook method: yes, I am too lazy to put this in a separate test case
ClassMethod Test()
{
	Set tags = ##class(%ListOfDataTypes).%New()
 	Do tags.Insert("fiction")
 	Do tags.Insert("non-fiction")
 	Do tags.Insert("cooking")
 	
 	write !, "tags Count: "_tags.Count()
 	
 	do ..CreateBook(tags)
}

/// ROOTDIR only accepts a relative path
Projection Java As %Projection.Java(ROOTDIR = "koo/src");

}
'