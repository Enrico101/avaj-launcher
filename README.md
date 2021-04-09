# avaj-launcher
This project is the introduction to the Java world at 42. This is an implementation of an aircraft simulation program based on the class UML diagram.
## Description
Aim of this project is to implement an aircraft simulation program based on the UML class diagram. All classes are required to be implemented respecting every detail provided in the diagram. If necessary, add more classes or include additional attributes, but changing access modifiers and class hireharchy for the classes provided in the diagram are forbidden.
## UML Diagram
![alt text](https://github.com/Enrico101/avaj-launcher/blob/main/docs/avaj_uml.jpg?raw=true)
## Compile and run
```
sudo git clone https://Enrico101/avaj-launcher.git
cd avaj-launcher
javac simulator.java
java simulator scenario.txt
```
## Scenario file example
```
25
Baloon B1 2 3 20
Baloon B2 1 8 66
JetPlane J1 23 44 32
Helicopter H1 654 33 20
Helicopter H2 22 33 44
Helicopter H3 98 68 99
Baloon B3 102 22 34
JetPlane J2 11 99 768
Helicopter H4 223 23 54
```
## Example output
```
cat simulation.txt
```
```
Tower says: Baloon#B1(0): has registered from the Tower.
Tower says: Baloon#B2(1): registered to weather tower.
Tower says: JetPlane#J1(2): registered to weather tower.
Tower says: Helicopter#H1(3): registered to weather tower.
Tower says: Helicopter#H2(4): registered to weather tower.
Tower says: Helicopter#H3(5): registered to weather tower.
Tower says: Baloon#B3(6): registered to weather tower.
Tower says: JetPlane#J2(7): registered to weather tower.
Tower says: Helicopter#H4(8): registered to weather tower.
== Simulation #0 ==
Baloon#B1(0): Some people say the fog is scary, but from view, its awesome.
Baloon#B2(1): Im going to freeze to death up here.
JetPlane#J1(2): Wish i was at home enjoying this miracle mother nature gave us.
Helicopter#H1(3): Dude, the fog is just so scary. You cant see where you going.
Helicopter#H2(4): It looks like its going to cold the entire day.
Helicopter#H3(5): Dude, the fog is just so scary. You cant see where you going.
Baloon#B3(6): Im going to freeze to death up here.
JetPlane#J2(7): Wish i was at home enjoying this miracle mother nature gave us.
Helicopter#H4(8): The rain is just awesome.
== Simulation #1 ==
Baloon#B1(0): Im going to get all wet now.
Baloon#B2(1): Im going to get all wet now.
JetPlane#J1(2): The sun is just breathtaking. Stay focused on flying the plain.
Helicopter#H1(3): It looks like its going to cold the entire day.
Tower says: Helicopter#H1(3): unregistered to weather tower.
Tower says: Helicopter#H1(3): has unregister from the tower and landed at the following coordinates. Latitude: 33, Longitude: 655, Height: 0
Helicopter#H3(5): It looks like smooth sailing from here.
Baloon#B3(6): Im going to get all wet now.
JetPlane#J2(7): The sun is just breathtaking. Stay focused on flying the plain.
Helicopter#H4(8): It looks like smooth sailing from here.
== Simulation #2 ==
........
```
## Author
Enrico Radcliffe - Enrico101
