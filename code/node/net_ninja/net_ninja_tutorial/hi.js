fs.writeFile('out.txt', uniqueMatches, (err)=>{
     if(err) throw err;
          console.log('Extract saved successful');
});