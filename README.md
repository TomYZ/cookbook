# cookbook
## Description
This is an Android App to display different types of food and details of these foods.

1. Food is group by types, such as: Indian, Chinese, America, etc.
2. In each type, there is a list of foods and pictures of these foods.
3. If you click on one of these foods, the name, picture, detail of this food will appear.

## Techonology
1. Using a GET request to get all JSON data, then parse to display on the screen.

   where I get JSON data:[http://www.edward-hu.com/cookbook](http://www.edward-hu.com/cookbook)

2. Using ExpandableListView to group and display foods, ParentView is a type name, ChildView is a food name.

3. If you click on one of these foods, build an AlertDialog filled with food name, food detail, food picture to display.

4. There are only 4 pictures available, and the default picture of the food is wonton if there is no name matches.
