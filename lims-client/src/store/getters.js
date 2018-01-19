const getters = {
    sidebar: state => state.app.sidebar,
    projectNo: state => state.project.projectNo,
    projectId: state => state.project.projectId,
    projectStatus: state => state.project.projectStatus,
    name: state => state.user.name,
    id: state => state.user.id,
    roles: state => state.user.roles,
    permission_routers: state => state.permission.routers,
    addRouters: state => state.permission.addRouters,
    showLoading: state => state.app.loading
};
export default getters
