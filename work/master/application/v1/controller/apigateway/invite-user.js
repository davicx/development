exports.requirements = {
    get: {
        requiredParams: ['invite_id']
    },
    post: {
        requiredBody: 'v1-user-invite-request'
    }
};

exports.post = async (request, response) => {
    request.body = response.body;
    return response;
};

exports.get = async (request, response) => {
    // add logical class for user invites
    console.log(request.params.invite_id)
    return response;
};
