const express = require('express');
const router = express.Router();
const mongoose = require('mongoose');
const User = require('../models/user');
var { Event } = require('../models/event');
const jwt = require('jsonwebtoken')
var ObjectId = require('mongodb').ObjectID;

//
mongoose.connect('mongodb://localhost:27017/eventsdb',(err) => {
    if(!err)
        console.log('MongoDB connection succeeded...');
    else
        console.log('Error in DB connection : '+ JSON.stringify(err,undefined,2));    
});


function verifyToken(req, res, next) {
  if(!req.headers.authorization) {
    return res.status(401).send('Unauthorized request')
  }
  let token = req.headers.authorization.split(' ')[1]
  if(token === 'null') {
    return res.status(401).send('Unauthorized request')    
  }
  let payload = jwt.verify(token, 'secretKey')
  if(!payload) {
    return res.status(401).send('Unauthorized request')    
  }
  req.userId = payload.subject
  next()
}

// router.get('/events', (req,res) => {
//   let events = [
//     {
//       "_id": "1",
//       "name": "Auto Expo",
//       "description": "lorem ipsum",
//       "date": "2012-04-23T18:25:43.511Z"
//     },
//     {
//       "_id": "2",
//       "name": "Auto Expo",
//       "description": "lorem ipsum",
//       "date": "2012-04-23T18:25:43.511Z"
//     },
//     {
//       "_id": "3",
//       "name": "Auto Expo",
//       "description": "lorem ipsum",
//       "date": "2012-04-23T18:25:43.511Z"
//     },
//     {
//       "_id": "4",
//       "name": "Auto Expo",
//       "description": "lorem ipsum",
//       "date": "2012-04-23T18:25:43.511Z"
//     },
//     {
//       "_id": "5",
//       "name": "Auto Expo",
//       "description": "lorem ipsum",
//       "date": "2012-04-23T18:25:43.511Z"
//     },
//     {
//       "_id": "6",
//       "name": "Auto Expo",
//       "description": "lorem ipsum",
//       "date": "2012-04-23T18:25:43.511Z"
//     }
//   ]
//   res.json(events)
// })

router.get('/special', verifyToken, (req, res) => {
  let specialEvents = [
    {
      "_id": "1",
      "name": "Auto Expo syonara",
      "description": "lorem ipsum",
      "date": "2020-23-12T18:25:43.511Z",
      "time": "7:00 PM"
    },
    {
      "_id": "2",
      "name": "Auto Expo explorica",
      "description": "lorem ipsum",
      "date": "2021-21-01T18:25:43.511Z",
      "time": "6:00 PM"
    },
    {
      "_id": "3",
      "name": "Auto Expo mantra",
      "description": "lorem ipsum",
      "date": "2021-13-02T18:25:43.511Z",
      "time": "9:00 AM"
    },
    {
      "_id": "4",
      "name": "Auto Expo glimpse",
      "description": "lorem ipsum",
      "date": "2021-21-02T18:25:43.511Z",
      "time": "9:00 PM"
    },
    {
      "_id": "5",
      "name": "Auto Expo surabhi",
      "description": "lorem ipsum",
      "date": "2021-26-03T18:25:43.511Z",
      "time": "11:00 PM"
    },
    {
      "_id": "6",
      "name": "Auto Expo samyak",
      "description": "lorem ipsum",
      "date": "2021-27-04T18:25:43.511Z",
      "time": "5:00 PM"
    }
  ]
  res.json(specialEvents)
})

router.post('/register', (req, res) => {
  let userData = req.body
  let user = new User(userData)
  user.save((err, registeredUser) => {
    if (err) {
      console.log(err)      
    } else {
      let payload = {subject: registeredUser._id}
      let token = jwt.sign(payload, 'secretKey')
      res.status(200).send({token})
    }
  })
})

router.post('/login', (req, res) => {
  let userData = req.body
  User.findOne({email: userData.email}, (err, user) => {
    if (err) {
      console.log(err)    
    } else {
      if (!user) {
        res.status(401).send('Invalid Email')
      } else 
      if ( user.password !== userData.password) {
        res.status(401).send('Invalid Password')
      } else {
        let payload = {subject: user._id}
        let token = jwt.sign(payload, 'secretKey')
        res.status(200).send({token})
      }
    }
  })
})




//=> localhost:3000/events/
router.get('/events',(req, res) => {
    Event.find((err,docs) => {
        if (!err) { res.send(docs); }
        else { console.log('Error in retriving events : '+ JSON.stringify(err, undefined, 2));   }
    });
});

router.get('/events/:id', (req, res) => {
    if (!ObjectId.isValid(req.params.id))
        return res.status(400).send('No record with given id : ${req.params.id}');
    Event.findById(req.params.id, (err, doc) => {
        if (!err) { res.send(doc); }
        else { console.log('Error in retriving events : '+ JSON.stringify(err, undefined, 2));   }

    });
});

router.post('/events', (req, res) => {
    var e = new Event({
        name: req.body.name,
        occasion: req.body.occasion,
        date_and_venue: req.body.date_and_venue,
        budjet: req.body.budjet,
    });    
    e.save((err, doc) => {
        if (!err) { res.send(doc); }
        else { console.log('Error in event save : '+ JSON.stringify(err, undefined, 2));   }    
    });
});

router.put('/events/:id', (req, res) => {
    if (!ObjectId.isValid(req.params.id))
        return res.status(400).send('No record with given id : ${req.params.id}');

    var e = {
        name: req.body.name,
        occasion: req.body.occasion,
        date_and_venue: req.body.date_and_venue,
        budjet: req.body.budjet,
    };
    Event.findByIdAndUpdate(req.params.id, {$set: e}, {new: true}, (err, doc) => {
        if (!err) { res.send(doc); }
        else { console.log('Error in event Update : '+ JSON.stringify(err, undefined, 2));   }    
    });
});   

router.delete('/events/:id', (req, res) => {
    if (!ObjectId.isValid(req.params.id))
        return res.status(400).send('No record with given id : ${req.params.id}');

    Event.findByIdAndRemove(req.params.id, (err, doc) => {
        if (!err) { res.send(doc); }
        else { console.log('Error in event Delete : '+ JSON.stringify(err, undefined, 2));   }    
    });
}); 



module.exports = router;