



# Introduction #
**Akira** is set of programs which visualizes atomistic or particle simulation results with volumetric visualization capability. The name "**Akira**" comes from the Chinese letter "**顕**" which is included in the word "**顕微鏡**" (microscope).

**Akira** is written by Java from scratch with OpenGL library for Java (JOGL). Because:
  * Java programs run almost the same way on various platforms.
  * Java language is appropriate for developing object-oriented programs.
  * OpenGL is so far a global standard 3D-graphic library. Hence we can obtain a lot documentations on the internet.


**Akira** is an open-source project hosted at Google Code as [project-akira](http://code.google.com/p/project-akira/).  You can see screenshots and download sample inputs from the site.



## Composition of Akira software package ##
**Akira** program package is composed of two programs: _AkiraConverter_ and _AkiraViewer_. _AkiraConverter_ converts sequential input data to a binary file which _AkiraViewer_ can recognize.  The reason why we split the converter and viewer is to make the visualization process faster by converting data before the visualization.



# Installation #
To run the Akira programs, you need Java and JOGL installed on the computer on which Akira will be installed. JOGL is the library package that you need to use OpenGL in Java programs. Akira is distributed in a binary format and you can obtain the current version from [here](http://code.google.com/p/project-akira/downloads/list).
Install procedures are different between Linux/MacOS system, and Windows system.



## MacOS X / Linux ##
What you need to do are:
**install JOGL libraries** install _Akira_ binary and some scripts
That's it.

### Install Java ###
In case of MacOS X (at least under 10.6), Java is already installed in a default setting. In case of Linux or Windows, install Java on your own (documentations about Java are easily obtained elsewhere).

### Install Akira package ###
Download a zip copy of the latest Akira package from [Downloads](http://code.google.com/p/project-akira/downloads/list) tab in this project. Then, extract the zip file and you can find _Akira/_ directory which includes binary and some scripts. To install _Akira_ package, you have to do `make install` in the directory as,
```
 $ cd ~/somewhere/Akira/
 $ make install
```
This `make install` command makes `~/Akira` directory, copies some files in this package to the directory, and writes shell environment setting in your `~/.bashrc` script.
(If you are using other shell programs like `tcsh` or `zsh`, you have to set `PATH` environment by yourself.)

### Install JOGL ###
Download the JOGL package from [here](http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/). This version may not be the latest release of the JOGL, because we didn't confirm that _Akira_ works with the latest version of JOGL.
The direct links to binaries are:
  * [MacOSX(universal)](http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/jogl-2.0-macosx-universal.zip)
  * [Linux (64bit CPU)](http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/jogl-2.0-linux-amd64.zip)
  * [Linux (32bit CPU)](http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/jogl-2.0-linux-i586.zip)
You have to put `lib` directory of the JOGL package to `~/Akira/jogl` as,
```
 $ cd ~/somewhere/jogl-2.0-macosx-universal
 $ cp -r ./lib ~/Akira/jogl
```

That's all. Now you can run _Akira_ program. Enjoy!


## Windows ##
Assuming that JOGL goes to _C:jogl_ and Akira to _C:Akira_. You also need to install JRE on your own. There are several instructions for the installation of JRE available on the internet.

### Installing JOGL ###
Unfortunately Akira may not work with the current version of JOGL. You should download older version of JOGL from [http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/](http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/).  The direct links are:
  * [Windows (64bit CPU)](http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/jogl-2.0-windows-amd64.zip)
  * [Windows (32bit CPU)](http://download.java.net/media/jogl/builds/archive/jsr-231-2.0-beta10/jogl-2.0-windows-i586.zip)
After decompressing the zip file, create _C:jogl_ and put _lib/_ directory into _C:jogl_. Then add PATH _C:jogl_ in control panel.

### Installing Akira ###
Download Akira.zip from [here](http://code.google.com/p/project-akira/downloads/list) and decompress the zip file.  Then create _C:Akira_ directory and put _Akira.jar_ file to the directory.  And also put _.bat_ files in _utils/shellscript-win/_ directory to an appropriate place.


# Usage #
Here we explain how to use **Akira** on MacOS X (10.6, snow leopard).  Note that, if you use it on the other platforms, commands and paths might be different from this instruction.

Assuming that the installation explained above is completed and the current working directory is _~/tmp/_. Hence there are _Akira.sh_, _AkiraConverter.sh_, and _AkiraViewer.sh_ in the _~/Akira/shellscript-mac/_ directory and _Akira.jar_ in the _~/Akira/_ directory. And are there three sequential input data named _akr001_, _akr002_, and _akr003_ in the current working directory.

First, you have to convert these there _akr00?_ files using _AkiraConverter_.  To run _AkiraConverter_, you need to prepare _AkiraConverter.conf_ file in the current working directory. Following shows an example of the _AkiraConverter.conf_.
```
#AkiraConv config file (starting with # is comment line)
#DON'T CHANGE ORDER OF ITEMS
#THE ORDER OF EACH ITEM IS IMPORTANT!!

#system name
sample

## read file (C like format)
#file-format:path:filename,startFrame,endFrame,Increment
### file-formats are;
###    akira, akiratgz, akiratbz2, akirabin, akirabintgz, akirabintbz2,
###    chgcar, cube, xyz, coord, xcrysden, xcrysdentgz, chem3d

akiratgz:./trans.tgz:out%03d,0,10,1

### start time, time interval
0.0 1.0e0

### create bonds?
false
### bond info: tag1, tag2, length[your unit]
1 2 4
### exist bondfile?
false
### bondfile
bond000

### cut x?, min[0:1], max[0:1]
false 0.5 0.8
### cut y?, min[0:1], max[0:1]
false 0.4 0.6
### cut z?, min[0:1], max[0:1]
false 0.0 1.0
### cut sphere? radius[your unit], center[0:1]
false -10 0.5 0.5 0.5
```
Here **system name** is the name of the binary file to be used by _AkiraViewer_. You have to specify the **file format** to be read; in this case, the file is text file of the akira format.  Then input file names should be specified; here this is written _./:akr%03d,1,3,1_ which means files of sequential number from 001 to 003 in this directory.  If these files are archived to the file _akr.tgz_, the **file format** should be _akiratgz_ and file names should be specified as _./akr.tgz:akr%03d,1,3,1_.
Then, run the _AkiraConverter_ as follows.
```
 $ ~/Akira/shellscript-mac/AkiraConverter.sh
```
This shell-script calls _AkiraConverter_ program in _~/Akira/Akira.jar_.  If there is no problem, _sample.Akira_ file will be created.
Once the binary file is created, you can run the _AkiraViewer_ with this binary file as follows.
```
 $ ~/Akira/shellscript-mac/AkiraViewer.sh ./sample.Akira
```
This shell-script calls _AkiraViewer_  program in "~/Akira/Akira.jar".
Or you can simply type
```
 $ ~/Akira/shellscript-mac/Akira.sh
```
to launch both _AkiraConverter_ and _AkiraViewer_ automatically.
The **Rendering** window and **View Configuration** window will appear!  Enjoy using **Akira**!


# AkiraConverter #
## Available formats (_format name_) ##
#### Akira format (akira, akiratgz, akiratbz2) ####
This is an original format in Akira software package. It includes number of atoms, simulation box, atom coordinates, auxiliary data for each atom, and 3D volumetric data.  Sample fortran code which creates Akira-format file is shown below.
```
c234567  
      outfile="out000"
      write(outfile(4:6),’(i3.3)’) iframe          !set the iframe-th output file-name  
      open(10,file=outfile)
      write(10,*) natom,ndata,nvblock,nvtot        !#of atoms, additional data, blocks and volumetric data
      write(10,*) h(1:3,1)                         !simulation box info.
      write(10,*) h(1:3,2)                         !simulation box info.
      write(10,*) h(1:3,3)                         !simulation box info.
c-----Output atom info.
      do i=1,natom
        adata(1)=kin(i)                            !1st additional data: kinetic energy per atom
        adata(2)=pot(i)                            !2nd additional data: potential energy per atom
        adata(3)=force(1,i)                        !3rd additional data: force x
        adata(4)=force(2,i)                        !4th additional data: force y
        adata(5)=force(3,i)                        !5th additional data: force z
        write(10,*) isp(i),r(1:3,i),adata(1:ndata) !species, normalized pos., additional data 
      enddo
c-----Output volumetric data 
      do iv=1,nvblock
        write(10,*) nvx(iv),nvy(iv),nvz(iv)        !# of division  
        write(10,*) orgvol(1:3,iv)                 !origin of volume data
        write(10,*) hvol(1:3,1,iv)                 !box of volume data
	write(10,*) hvol(1:3,2,iv)                 !box of volume data
	write(10,*) hvol(1:3,3,iv)                 !box of volume data
	do iz=1,nvz(iv)
	do iy=1,nvy(iv)
	do ix=1,nvx(iv)
          write(10,*) rho(ix,iy,iz,iv)             !volume data (electron density)
	enddo
	enddo
	enddo
      enddo
      close(10)
```
#### CHGCAR (chgcar) ####
The ab initio calculation program _VASP_ writes results in this format.
#### Gaussian cube (cube) ####
Some programs including _Gaussian_ and _CP2K_ write results in this format.  Gaussian cube format consists of simulation box matrix, atom positions, and volumetric data.


# AkiraViewer #
AkiraViewer visualizes atoms or particles positions, bonds, and volumetric data read from the converted binary data file.

## Functions ##
#### Drawing atoms or particles by points or polygons (sphere) ####
_AkiraViewer_ can draw atoms or particles by points, spheres with realistic representation, or spheres with cartoon-like representation. You can change the drawing mode by pressing 'r' button. You can also change resolution (or slices) of polygons at a **atoms panel**.

#### Drawing bonds by lines or cylinders ####
You can draw bonds which connect atoms or particles by lines or cylinders. By pressing 'b', you can toggle drawing bonds and you can change representation of bonds by pressing 'B (or shift+b)'.  Bonds are created either by _AkiraConverter_ or within _AkiraViewer_. In **bonds panel**, you can choose which atomic species to be connected by creating bonds.

#### Drawing vectors using auxiliary data for each atom ####
Vectors which are originated from each atom can be drawn by pressing 'v' button using any auxiliary data set. You have to choose 3 auxiliary data per each atom to draw a vector. Vector can be drawn by line or cylinder; toggled by button 'V'.

#### Drawing trajectory of atom motion ####
For example, when we simulate the negative electrode of Li-ion battery, the trajectory mode allows you to draw the trajectory of a certain atom (i.e., Li-ion).  The trajectory can be drawn by line or cylinder.

#### Customizing light setting ####
If you want to change how they look, for example, the position of light sources, light types, texture of materials, etc., you can customize by changing values in **light panel**.

#### Customizing background, text, and simulation box colors ####
You can also customize background color in **color panel**, text and simulation-box colors as well.

#### Saving current configuration, viewing direction, etc. ####
The current configuration, such as viewing direction, background color, sphere and cylinder radius, atom colors is saved in _~/.Akira/_ directory automatically.

#### Exporting sequential images by several image formats ####
By pressing 'w' button, the image of current frame is exported to file 'seq00000.png' by PNG format.

#### Cutting arbitrary faces ####

#### Drawing 3D volumetric data as an iso-surface and 2D contour ####
If input files contain 3D volumetric data, you can draw iso-surface and sliced 2D contour.  However it is still not good quality. Iso-surface is not smooth and jaggy.

#### Calculation of the pair distribution function ####

#### Automating the batch process ####
Batch processes can be automated by registering the process in **Combo panel**.  You can export and import the batch processes so that the completely same process can be applied to different input data set.

#### Selecting individual atoms and getting information of atoms, bonds, and angles ####
You can activate the atom selection mode by checking the box in **atoms panel**. Once you select an atom by clicking the atom, information about the atom such as index, species-ID, position, etc. are displayed in information area and the atom index is stored. If you select second atom, you can obtain the length between the atom just selected and stored before as well as the individual atom information. If you select third atom, you can obtain the angle as well.


## Key operations ##
Selected key operations are listed below.  You can see all of key operations from **Help** menu on top of the **View Configuration** window.

|  | **Key** | **Effect** |
|:-|:--------|:-----------|
|  | esc | Quit |
|  | arrows | Rotations |
| Shift | arrows | Translations |
|  | 0 | Change coloring by species-ID |
|  | 1,2,3,.. | Change coloring by auxiliary data |
|  | b | Toggle drawing bonds |
| Shift | b | Toggle bond representation |
| Alt | b | Toggle showing box |
|  | r | Toggle atom representation |
|  | w | Export image file of current frame |


# Tips #
#### Something wrong with Akira ####
At first, remove the Akira setting directory _~/.Akira_ or _C:Akira_.

#### Making movie from sequential output images ####
_AkiraViewer_ exports sequential PNG images by pressing 'W' button. We can get a movie file by converting these sequential images using a certain third party program.
By using [image magic](http://www.imagemagick.org/script/index.php) command-line tool as
```
 $ convert -delay 20 *.png a.mpg
```
you can get a MPEG file _a.mpg_.


# Known bugs #
#### Cannot quit AkiraViewer by pressing esc button ####
This problem might have to do with the window focusing problem. Although the **View Configuration** window is responsible for quitting the program, if the focus is not on the window, esc button does not work properly. In such a case, you can quit the program by clicking the **Exit** in the **File** menu in the **View Configuration** window.

#### Program crashes when you press edit button in the Trajectory panel ####


# Feedback #
Please leave bug reports, comments and request to [here](http://code.google.com/p/project-akira/issues/list).