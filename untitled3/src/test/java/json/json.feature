Feature: json feature testing

  Scenario: json feature reader parse

    * def jsonObject =
    """
    [
    {
    "name" : "Anand",
    "place" : "Bangalore"
    },
     {
    "name" : "Kiran",
    "place" : "Vizag"
    }
    ]
    """

    * print jsonObject
    * print jsonObject[0].name

  Scenario: Complex json feature reader parse
    * def jsonObject =
    """
    {"menu": {
  "id": "file",
  "value": "File",
  "popup": {
    "menuitem": [
      {"value": "New", "onclick": "CreateNewDoc()"},
      {"value": "Open", "onclick": "OpenDoc()"},
      {"value": "Close", "onclick": "CloseDoc()"}
    ]
  }
}
}
   """
    * print jsonObject
    *  print jsonObject.menu
    * print jsonObject.menu.id
    * print jsonObject.menu.popup
    * print jsonObject.menu.popup.menuitem
    * print jsonObject.menu.popup.menuitem[0].value
    * print jsonObject.menu.popup.menuitem[0].onclick