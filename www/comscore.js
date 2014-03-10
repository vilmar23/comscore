var argscheck = require('cordova/argscheck'),
    utils = require('cordova/utils'),
    exec = require('cordova/exec');

var comScorePlugin = function(src, successCallback, errorCallback, statusCallback) {
    exec(null, this.errorCallback, "comScorePlugin", "create", [this.src]);
};

module.exports = comScorePlugin;

