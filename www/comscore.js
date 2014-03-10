var argscheck = require('cordova/argscheck'),
    utils = require('cordova/utils'),
    exec = require('cordova/exec');

var comScorePlugin = function(c2, PublisherSecret) {
    exec(null, this.errorCallback, "comScorePlugin", "create", [c2 , PublisherSecret]);
};

module.exports = comScorePlugin;

