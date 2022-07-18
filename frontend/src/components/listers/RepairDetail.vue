<template>
    <v-card outlined>
        <v-card-title>
            Repair # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="PurifierStatus" v-model="item.purifierStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PurifierId" v-model="item.purifierId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="RepairId" v-model="item.repairId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="RepairmanId" v-model="item.repairmanId" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'RepairDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/repairs/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
        },
    };
</script>
