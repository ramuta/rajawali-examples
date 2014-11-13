Rajawali Examples
=================

Some of my Rajawali Android Open GL 2 ES lib examples

## How to set it up ##

1. Download the latest Rajawali stable version: https://github.com/MasDennis/Rajawali/releases
2. Unzip it
3. Open your project in IntelliJ IDEA and go to File > Project Structure
4. Select Modules > + (plus button) > Import module and import Rajawali lib
5. Rajawali will probably be missing a dependency to Android Support Library v4. So in Project Structure select
Rajawali > Dependencies > + (bottom) > JARs or dependencies > Rajawali lib folder > libs > android-support-v4.jar.
6. Next you have to add Rajawali as dependency to your project: File > Project Structure > Modules > app >
Dependencies > + (bottom) > Module dependency > Rajawali
7. That's it! Now start with the first tutorial:
[https://github.com/MasDennis/Rajawali/wiki/Tutorial-01----Basic-Setup-&-a-Sphere](https://github.com/MasDennis/Rajawali/wiki/Tutorial-01----Basic-Setup-&-a-Sphere)

Important: Don't use Gradle to build your project - Rajawali doesn't go well with it :)