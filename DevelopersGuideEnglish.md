


# Developer's manual #
## Policy ##
#### It is not your toy ####
There are already a lot of visualization softwares in the world. So what is the benefit of developing own code? The merit is that it is easier to customize the software to realize what you want to do, if you know inside the code. Hence, it is important that:
  1. the developers understand deeply inside the code and the code is simple enough to be understand,
  1. each function is highly independent and created as a simple capsule,
  1. the software is rather extensible than having a lot of functions.

#### Make the code object-oriented ####
We adopt Java because it is appropriate language for writing object-oriented code. The function should be written as an object that has enough properties and provides right operations. The independency of each object makes the program easy to understand and transferable.

#### Follow the Model-View-Controller (MVC) model (if it is possible) ####
If the code is written based on the MVC model, each component is transferable and easy to be maintained. In case of **Akira**, the model is a bunch of atoms and should be independent from the view.

#### Write the code platform-independent ####
One of the merits to writing the code in Java is that once you write the code, it runs every platforms. So you need to avoid writing platform-dependent codes.

#### Keep It Small and Simple (KISS) ####
KISS is a policy of Java. It is easy to maintain the code and thus decreases bugs, if the code is simple.

#### Do not change the way to use so often ####
End users do not want to change their input files so often. So the input format and how-to-use should not be changed frequently. However, some changes need modification of input format or how-to-use of the software.  You should make changes on your own branch at first. When you are convinced the changes are good for every users, you have to consult with other developers before you update main branch. Then you have to announce about the changes properly to users.

#### Do not access to instance variable from outside of the class ####
Instance variables should be declared as private or protected. They should be accessed by using getter and setter (accessor) methods. But instance variables can be public in following cases:
  1. they are independent from other variables and do not violate the consistency,
  1. there appears a lot of getter and setter methods if they are not public,
  1. the usage of the variables won't be changed in the future.
And sometimes the variables should be public with respect to efficiency.

#### Choose readability rather than efficiency ####
Computation efficiency is important, but most important thing in this software is readability.


## Coding rules ##
Since Akira is developed by several developers, we here decide the rules for writing source codes. We strongly request each developer to follow these rules. However developers can violate these rules if they have valid reasons.

#### Public class must be written in the file of name of the class ####
This might be a rule of Java language. Non public classes can be included in any file.

#### 2-space-letters for indentation ####
Usually in Java language 4-space-letters are used for an indentation. But we think it is too much spaces for an indentation.  If you are using _emacs_ as an editor, it can be achieved by writing following to the emacs setting file.
```
(autoload ’c++-mode "cc-mode" "C++ Editing Mode" t)
(autoload ’c-mode   "cc-mode" "C Editing Mode" t) 
(autoload ’java-mode "cc-mode" "Java Editing Mode" t) 
(add-hook ’c-mode-common-hook
    ’(lambda () 
        (setq c-indent-level 2)
        (setq c-brace-imaginary-offset 0) 
        (setq c-argdecl-indent 2) 
        (setq c-continued-statement-offset 2) 
        (setq c-label-offset -2) 
        (setq c-brace-offset 0) 
        (setq tab-width 2) 
        (setq c-basic-offset 2) 
        (setq comment-style ’extra-line) 
        (setq comment-start "/*") 
        (setq comment-end "*/") 
    ))
```

#### A line should not have more than 80 letters ####
Since variable names are rather long in Java language, a line tends to be long.  But if it is too long, you should break the line to make it easy to read.

#### Write comments ####
Since Akira is developed by several developers, if you think that the code you are writing is not easy for the others to understand, you should write proper comments.  The comments make the code easy to be understand, and thus reduce bugs. Consequently total time to be spent for developing the program will be shorter than the case that you don't write any comments. Furthermore, Java has the function called **Javadoc** which creates document of the source codes from comments.  If you write appropriate comments, document of the program is automatically generated.  You can write comments in Japanese, but in such case, the character code must be set to _UTF-8 no BOM_.

#### Name of a class should be the object name not only noun ####
Since each class is an object, the name of a class should be the name of the object. For example, if you make a class that converts the unit of money, the name of the class should be _MoneyConverter_ not _ConvertingMoney_.

#### Class name should start with uppercase letter, variable and method names should start with lowercase letter ####
It is the naming rule in Java that class name starts with uppercase letter and, if the name consists of several words, first letters of each word should be uppercase, for example, _SuperGreatGoalKeeper_.  On the other hand, the names of variables and methods should start with lowercase letters, for example, _doSomethingWithSomebody()_.  This rule is called **CamelCase** rule.

#### All the letters for constant names should be uppercase ####
In this case, since it is hard to see the break of words, you can use underscore to connect words, e.g., _MAX\_NUM\_OF\_ATOMS_.

#### Variable name should be meaningful even if it gets long ####
For example, if the boolean type variable to be used to judge whether the atom is visible or not would be _isVisible_.

#### Try to write precisely for import sentence ####
If you use _for import sentence, the others cannot recognize easily which classes are necessary. However if you import more than three classes from the same package, you can write **import package-name.**_ to avoid verbosity.


## Revision management ##
**Mercurial** is adopted for the revision management of Akira because the [Google Code](http://code.google.com/intl/ja/) specifies to use it. The usages of Mercurial is found somewhere else on the internet.  Here we describe some rules to use Mercurial.

#### Write simple and adequate comments when you commit ####
You must write some comments when you commit changes. The other developers see just a first line of the commit-comment. Hence you should write simple and adequate comments, which you can write more than one line though.

#### Commit changes after checking bugs ####
The commit is by no means a save of changes.  So the commit would not be made so often.  After you confirm there are no bugs caused by the changes, you can commit the changes to the repository.



# Manual in Japanese #
[AkiraManual.pdf](http://project-akira.googlecode.com/files/AkiraManual.pdf)