var messecksBox = {
    _box: null,
    get box() {
        if (!this._box) {
            this._box = {
                createMeeseck: function() {
                    console.log("amethod");
                }
            }
        }
        return this._box;
    }
};