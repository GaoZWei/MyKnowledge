import {queryKnowledge, deleteKnowledge, modifyKnowledge, addKnowledge,shareKnowledge} from '../services/knowledge'
import {routerRedux} from "dva/router";

export default {
  namespace: 'knowledges',
  state: {
    knowledgeList: [],
    knowledgeModelList: []
  },
  reducers: {
    queryKnowledgeSuccess(state, {payload}) {
      state.knowledgeList = payload
      return {...state}
    },
  },
  effects: {
    * queryKnowledge(payload, {put, call}) {
      const result = yield call(queryKnowledge);
      console.log(result)
      if (result) {
        yield put({
          type: 'queryKnowledgeSuccess',
          payload: result.data
        });
      }
    },
    * deleteKnowledgeById({payload}, {put, call}) {
      // const id = payload
       console.log(payload)
      yield call(deleteKnowledge,payload);
      yield put({
        type: 'queryKnowledge'
      })
    },
    * modifyKnowledgeById({payload}, {put, call}) {
      console.log('model: ',payload)
      yield call(modifyKnowledge, payload.values);
      yield put({
        type: 'queryKnowledge'
      })
    },
    * addKnowledge({payload}, {put, call}) {
      console.log(payload)
      yield call(addKnowledge, payload)
      let { inputData} = payload;
      yield call(addKnowledge, inputData);
      yield put(routerRedux.push('/knowledge'));
    },
    *shareKnowledgeById({payload}, {put, call}) {
      console.log(payload)
      yield call(shareKnowledge,payload);
      yield put(routerRedux.push('/share'));
    },
  },
  subscriptions: {
    setup({dispatch, history}) {
      history.listen(location => {
        if (location.pathname === '/knowledge') {
          dispatch({
            type: 'queryKnowledge',
            //payload: {}
          });
        }
      });
    },
  },
}
