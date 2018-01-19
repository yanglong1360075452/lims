const project = {
    state: {
        projectNo:null,
        projectId:null,
        projectStatus:null
    },
    mutations: {
        setProjectId(state,projectId){
            state.projectId =   projectId;
        },
        setProjectNo(state,projectNo){
            state.projectNo =   projectNo;
        },
        setProjectStatus(state,projectStatus){
            state.projectStatus =   projectStatus;
        }
    }
};

export default project;
