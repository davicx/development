thisdict = {
  "brand": "Ford",
  "model": "Mustang",
  "year": 1964
}

myDict = {
  "brand": "Ford",
  "electric": False,
  "year": 1964,
  "colors": ["red", "white", "blue"]
}


people = {
  "frodo": "baggins",
  "david": "v",
  "bilbo": "baggins"
}

shire = {
  "location": "middle earth",
  "people": people
}   

#print(shire["people"]["frodo"])

for x, y in shire.items():
  pass
  #print(x, y)

#Nested Dictionary
frodo = {
  "name" : "frodo",
  "location" : "shire"
}
bilbo = {
  "name" : "bilbo",
  "location" : "shire"
}
david = {
  "name" : "david",
  "location" : "corvallis"
}

shire = {
  "frodo" : frodo,
  "bilbo" : bilbo,
  "david" : david
}

print(shire)

