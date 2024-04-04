
function verifyUser(req, res, next) {
    console.log("____________________________________________")
    console.log("Your logged in!")
    //res.status(498).json(responseMessage)
    console.log("____________________________________________")
    next()
}

  

module.exports = { verifyUser };

