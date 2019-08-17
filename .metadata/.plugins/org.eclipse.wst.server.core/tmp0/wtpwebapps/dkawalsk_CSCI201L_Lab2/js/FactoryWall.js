/**
 * 
 */

function FactoryWall(cell,wall)
{
	var name = wall['name'];
	var img = document.createElement('img');
	img.id = name;
	img.src = 'img/' + wall.image;
	cell.appendChild(img);
}