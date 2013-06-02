There are times when you need to print all attributes for a class. For doing that you have to manually call getter methods for each attribute of the class. To simplify the process, you can use the custom class __ObjectPrinter.java__

__ObjectPrinter.java__  
This class overrides toString() method of Object class and prints all the attributes that support java bean naming standards. The class whose attributes you want to print must extend this class.

__Person.java__  
Sample class having java bean standard methods.

__ObjectPrinterTest.java__  
Provides sample implementation of ObjectPrinter class.  