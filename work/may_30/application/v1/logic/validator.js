
/*
exports.committedUnitExists = async (request, response) => {
    const { committed_unit_id, production_plan_id } = request.params;
    let result = null;
    result = await committedUnitsFactory.getById(committed_unit_id, production_plan_id);
    if (!result || !result.export) {
        response.code = 404;
        response.setError(
            'committed_unit_id,production_plan_id',
            `committed unit with not found with the given parameters`
        );
    }
    return !response.hasErrors;
};

exports.isValidCommittedUnitPatch = (request, response) => {
    const { production_plan_id, committed_unit_id } = request.params;

    if (!committed_unit_id || !production_plan_id) {
        response.code = 400;
        response.setError('committed_unit_id,production_plan_id', 'committed_unit_id and production_plan_id required.');
    }

    return !response.hasErrors;
};

*/