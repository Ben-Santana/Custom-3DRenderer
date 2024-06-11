## OVerview

Coding project in Java to explore the ground work of 3D computer graphics.

## Libraries

I used java.swing and java.awt for displaying the 3D objects.

## Class structure

The Polyhedron parent class handles rotation, movement and drawing of all 3D objects. All 3D objects are made up of triangles which are made up of 3 vertex coordinates. The current subclasses of the Polyhedron class, Cube and Tetrahedron, handle the construction of the corresponding shapes.


## Custom perspective emulating projection

I decided to work out the math required to render the 3d objects in a perspective view as opposed to orthographically. Instead of using matrix multiplication to achieve this, I used the the proportion of the position of each vertex to the size of the plane of the camera's FOV at that z value, and scaled its position accordingly to the window.

## TODO:

- Explore different and more effecient and flexible forms of lighting
- Add more in depth camera functionality including ability to move camera / camera spaces
- Make more accesible to use in seperate projects
