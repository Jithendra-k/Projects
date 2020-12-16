const mongoose = require('mongoose');

var Event=mongoose.model('Event',{
    name: { type: String },
    occasion: { type: String },
    date_and_venue: { type: String },
    budjet: { type: Number }
});

module.exports = { Event } ; 
