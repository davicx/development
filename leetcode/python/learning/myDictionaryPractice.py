class myHashMap:
    def __init__(self):
        self.size = 10
        
        #Force Python to Create Empty List of Size 10
        self.map = [None] * self.size
        self.current_keys = set()

    def _get_hash(self, key):
        hash = 0
        
        if isinstance(key, int):
            #print("Integer")
            hash = key % 10
        elif isinstance(key, str):
            hash = int(len(key) % 10)
            #print("String ")
        else: 
            print("Invalid Key")
        
        #print(hash)
        return hash
        """
        for char in str(key):
                hash += ord(char)
        return hash % self.size
        """

    #View Values in Dictionary
    def view_values(self):
        #self.map.append(3)
        #self.map.insert(1, "Hiya")
        print(self.map)
        #for item in self.map:
        #    print(item)

    #Add a Value
    def add(self, key, value):
        hash_key = int(self._get_hash(key))
        key_value = [key, value]
        #print(self.current_keys)

        #Check if Key is Unique
        if key in self.current_keys:
            print("The key '", key ,"' is already taken")
        else:
            self.current_keys.add(key)

            #No Collisions
            if self.map[hash_key] is None:
                new_item = [key, value]
                self.map[hash_key] = [new_item]
                return True

            #Collision so Chain 
            else: 
                new_item = [key, value]
                #print(new_item, " Collision")
                self.map[hash_key].append(key_value)
                return True
        
    #Get a Value
    def get(self, key):
        key_hash = self._get_hash(key)
        #print(key, ' ', key_hash)
        chained_list = self.map[key_hash]
        for item in chained_list:
            if item[0] == key:
                return item[1]

        return None

    #Delete a Value
    def delete(self, key):
        key_hash = self._get_hash(key)
        #print(key, ' ', key_hash)
        if self.map[key_hash] is None:
            print("The Map does not contain this key")
            return False
        else:
            #print("Found")
            delete_index = -1
            cell_items = self.map[key_hash]
            #print(cell_items)
    
            for i in range (0, len(cell_items)):
                if cell_items[i][0] == key:
                    #print("deleting ", cell_items[i], " ", i)
                    delete_index = i
                else:
                    pass
                    # print(cell_items[i])
            #print(" Delete ", delete_index)      
            del self.map[key_hash][delete_index]
            #print(self.map[key_hash][delete_index])      
        
            return True
  
myMap = myHashMap()

#print(myMap.size)
myMap.add(1,"bilbo")
myMap.add(3,"frodo")
#myMap.add(1,"davey")
myMap.add("a","davey")
myMap.add("s","sam")
#myMap.get_hash("hiya")

#print("Your Value is ", myMap.get('a'))
myMap.view_values()
#print(myMap.delete('a'))
print(myMap.delete('gayd'))
myMap.view_values()

#hash_key = hash('xyz')
 
 