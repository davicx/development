

/*
const dataAdapter = require('@syngenta-digital/dta');

class UserInvites {
    constructor(dta) {
        const data_adapter = dta || dataAdapter;
        this._adapter = data_adapter.getAdapter({
            engine: 'dynamodb',
            endpoint: process.env.DYNAMODB_ENDPOINT,
            table: process.env.DYNAMODB_USER_INVITES,
            modelSchema: 'v1-user-invite-model',
            modelSchemaFile: 'application/openapi.yml',
            modelIdentifier: 'invite_id',
            modelVersionKey: 'modified'
        });
    }
    async getInvite(invite_id) {
        const result = await this._adapter.read({
            operation: 'get',
            query: {
                Key: {
                    invite_id
                }
            }
        });
        return result;
    }
}

module.exports = UserInvites;
*/