module.exports.Status = {
  PASS: "Pass",
  FAIL: "Fail",
  RESOLVED: "Resolved",
  WORKAROUND: "Workaround"
};
module.exports.Categories = {
  CONFIG: "Configuration",
  SERVICES: "Services",
  MISC: "Misc"
};
module.exports.HttpConstants = {
  LOCALHOST: "http://localhost:"
};
module.exports.Endpoints = {
  GET_CONFIG: "/api/v1/getConfig",
  INITIATE_TESTS: "/api/v1/run",
  EXIT: "/api/v1/exit"
};
