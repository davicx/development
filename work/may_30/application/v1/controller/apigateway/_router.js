const {Router} = require('@syngenta-digital/alc').apigateway;

exports.route = async (event) => {
    const router = new Router({
        event: event,
        basePath: `${process.env.SERVICE}/v1`,
        handlerPath: 'application/v1/controller/apigateway',
        schemaPath: 'application/openapi.yml',
        globalLogger: true
    });
    return router.route();
};
