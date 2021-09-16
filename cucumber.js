const feature = [`testcafetests/features/*.feature`].join(' ');
const steps = ['--require testcafetests/features/step-definitions/*.js'];
module.exports = {
    default:  feature,
    steps,
    retry: 1
};
